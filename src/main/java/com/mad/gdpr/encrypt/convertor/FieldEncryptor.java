package com.mad.gdpr.encrypt.convertor;

import com.mad.gdpr.encrypt.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FieldEncryptor<T> implements AttributeConverter<T, String> {

    @Autowired
    EncryptionService encryptionService;

    @Override
    public String convertToDatabaseColumn(T s) {
        return (String) encryptionService.encrypt( s );
    }

    @Override
    public T convertToEntityAttribute(String s) {
        return (T) encryptionService.decrypt( s );
    }
}
