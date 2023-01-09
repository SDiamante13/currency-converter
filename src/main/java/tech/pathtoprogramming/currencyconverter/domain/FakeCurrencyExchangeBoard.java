package tech.pathtoprogramming.currencyconverter.domain;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class FakeCurrencyExchangeBoard implements ExchangeBoard {

    @Override
    public BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency)

    {
        return valueOf(0.96);
    }
}
