package tech.pathtoprogramming.currencyconverter.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MoneyCalculator {

    public BigDecimal calculate(BigDecimal basePrice, BigDecimal exchangeRate) {
        return basePrice.multiply(exchangeRate);
    }
}
