package com.renault.gdpr;

import org.springframework.stereotype.Component;

@Component
public class EncryptionService {

    public Object encrypt( Object data ){

        if( data != null) {
            data += " { ENCRYPTED } ";
        }
        return data;
    }

    public Object decrypt( Object data ){

        String plainText = null;
        if( data != null ) {
            plainText = data.toString().replace(" { ENCRYPTED } ", "");
        }
        return plainText;
    }
}
