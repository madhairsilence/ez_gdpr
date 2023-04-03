package com.renault.gdpr.encrypt.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.renault.gdpr.encrypt.EncryptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class EncryptionSerializer extends JsonSerializer<Map> {

    private Logger logger = LoggerFactory.getLogger( EncryptionSerializer.class );

    EncryptionService encryptionService = new EncryptionService();

    public EncryptionSerializer() {
        super();
    }

    @Override
    public void serialize(Map t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();

        t.forEach((k,v)->{
            try {
                jsonGenerator.writeObjectField(  k.toString() ,encryptionService.encrypt( v ));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        jsonGenerator.writeEndObject();
    }
}


