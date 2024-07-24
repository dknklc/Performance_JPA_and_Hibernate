package com.dekankilic.performance.domain;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.util.Currency;

@Embeddable
public class Amount {
    private BigDecimal value;
    private Currency currencyCode;

    public Amount() {
    }

    public Amount(BigDecimal value, Currency currencyCode) {
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public static Amount of(int value, String code) {
        return new Amount(BigDecimal.valueOf(value), Currency.getInstance(code));
    }
}
