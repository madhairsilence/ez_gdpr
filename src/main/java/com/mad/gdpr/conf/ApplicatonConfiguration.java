package com.mad.gdpr.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mad.gdpr.encrypt.serializer.DecryptionSerializer;
import com.mad.gdpr.encrypt.serializer.EncryptionSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Map;

@Configuration
public class ApplicatonConfiguration {

    @Bean
    @Primary
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean("encryptor")
    public ObjectMapper encryptionMapper(){

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer( Map.class , new EncryptionSerializer());
        mapper.registerModule( module );

        return mapper;
    }

    @Bean("decryptor")
    public ObjectMapper decryptionMapper(){

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer( Map.class , new DecryptionSerializer());
        mapper.registerModule( module );

        return mapper;
    }
}
