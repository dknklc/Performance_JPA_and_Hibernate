package com.dekankilic.performance.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class PhoneNumber {
    private String number;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        HOME,
        WORK
    }

    public PhoneNumber() {
    }

    public PhoneNumber(String number, Type type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public Type getType() {
        return type;
    }
}
