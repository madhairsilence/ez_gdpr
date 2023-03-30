package com.renault.gdpr;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GDPRInterceptor {

    private Logger logger = LoggerFactory.getLogger( GDPRInterceptor.class );

    @Autowired
    EncryptionService encryptionService;

    @Around("@annotation(GDPR)")
    public Object intercept(ProceedingJoinPoint joinPoint ) throws Throwable {
        logger.info( " Method execution begins" );

        Object[]  params = joinPoint.getArgs();

        for( int index = 0 ; index < params.length ; index++ ){
            params[index] = encryptionService.encrypt( params[index] );
        }

        Object response = joinPoint.proceed(params);

        logger.info ( " Method execution complete" );

        return encryptionService.decrypt(response);
    }
}

INFO 9068 --- [nio-8080-exec-2] GDPRInterceptor                          :  Method execution begins
INFO 9068 --- [nio-8080-exec-2] GDPRController                           :  Data in the encryption controller SampleText { ENCRYPTED }
INFO 9068 --- [nio-8080-exec-2] GDPRService                              :  Data inside create service SampleText { ENCRYPTED }
INFO 9068 --- [nio-8080-exec-2] GDPRInterceptor                          :  Method execution complete