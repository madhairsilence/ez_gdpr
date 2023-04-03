package com.renault.gdpr.encrypt;

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
        return mask(plainText);
    }

    public Object mask( Object data ){
        String maskedText = null;
        String dataAsString = data.toString();
        if( data != null )
            maskedText = dataAsString.replace( dataAsString.substring( 1, 3 ), "XXX");
        return maskedText;
    }
}
