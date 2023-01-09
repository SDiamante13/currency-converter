package tech.pathtoprogramming.currencyconverter.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MoneyCalculator {



    public BigDecimal calculate(BigDecimal basePrice, BigDecimal exchangeRate) {

        BigDecimal calculatedMoney = exchangeRate.multiply(basePrice);//
        // throw new UnsupportedOperationException("need to implement");
        return calculatedMoney;
    }
}
