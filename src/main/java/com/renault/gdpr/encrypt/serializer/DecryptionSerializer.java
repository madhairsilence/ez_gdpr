package com.renault.gdpr.encrypt.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.renault.gdpr.encrypt.EncryptionService;

import java.io.IOException;
import java.util.Map;

public class DecryptionSerializer extends JsonSerializer<Map> {

    EncryptionService encryptionService = new EncryptionService();

    public DecryptionSerializer() {
        super();
    }

    @Override
    public void serialize(Map t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        t.forEach((k,v)->{
            try {
                jsonGenerator.writeObjectField(  k.toString() ,encryptionService.decrypt( v ));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        jsonGenerator.writeEndObject();
    }
}
