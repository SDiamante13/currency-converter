package tech.pathtoprogramming.currencyconverter.domain;

import java.math.BigDecimal;

public interface ExchangeBoard {
    BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency);
}
