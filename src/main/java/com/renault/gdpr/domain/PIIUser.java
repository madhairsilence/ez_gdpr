package com.renault.gdpr.domain;

import com.renault.gdpr.encrypt.convertor.StringEncryptor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PIIUser {

    @Id
    @GeneratedValue
    private Integer id;

    @Convert( converter = StringEncryptor.class )
    private String name;

    public PIIUser(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
