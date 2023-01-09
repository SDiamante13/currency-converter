package tech.pathtoprogramming.currencyconverter.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum Currency {
    USD,
    EUR,
    GBP
}
