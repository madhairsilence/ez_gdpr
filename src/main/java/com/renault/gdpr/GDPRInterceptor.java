package com.renault.gdpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Map;

@Aspect
@Component
public class GDPRInterceptor {

    private Logger logger = LoggerFactory.getLogger( GDPRInterceptor.class );

    @Autowired ObjectMapper mapper;

    @Autowired @Qualifier("encryptor") ObjectMapper encryptor;

    @Autowired @Qualifier("decryptor") ObjectMapper decryptor;

    @Around("@annotation(GDPR)")
    public Object intercept(ProceedingJoinPoint joinPoint ) throws Throwable {
        logger.info( " Method execution begins" );

        Object[]  params = joinPoint.getArgs();
        Class<?> aClass = null;
        Map<String,Object> intermediateData = null;

        for( int index = 0 ; index < params.length ; index++ ){
            aClass = params[index].getClass();
            intermediateData = mapper.convertValue( params[index], new TypeReference<Map<String, Object>>() {});
            params[index] = encryptor.convertValue(intermediateData, aClass);
        }

        Class returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();

        Object response = joinPoint.proceed(params);

        intermediateData = mapper.convertValue(response, new TypeReference<Map<String, Object>>() {});
        response = decryptor.convertValue( intermediateData , returnType );
        logger.info ( " Method execution complete" );

        return response;
    }
}
