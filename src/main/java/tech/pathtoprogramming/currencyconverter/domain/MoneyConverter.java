package tech.pathtoprogramming.currencyconverter.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MoneyConverter {
    private final ExchangeBoard exchangeBoard;
    private final MoneyCalculator moneyCalculator;

    public MoneyConverter(@Qualifier("fakeExchangeBoard") ExchangeBoard exchangeBoard, MoneyCalculator moneyCalculator) {
        this.exchangeBoard = exchangeBoard;
        this.moneyCalculator = moneyCalculator;
    }

    public Money convert(String basePrice, String baseCurrency, String targetCurrency) {
        throw new UnsupportedOperationException("need to implement");
    }
}
