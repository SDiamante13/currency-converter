package tech.pathtoprogramming.currencyconverter.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static tech.pathtoprogramming.currencyconverter.domain.Money.createMoney;

@Component
public class MoneyConverter {
    private final ExchangeBoard exchangeBoard;
    private final MoneyCalculator moneyCalculator;

    public MoneyConverter(@Qualifier("fakeExchangeBoard") ExchangeBoard exchangeBoard, MoneyCalculator moneyCalculator) {
        this.exchangeBoard = exchangeBoard;
        this.moneyCalculator = moneyCalculator;
    }

    public Money convert(String basePrice, String baseCurrency, String targetCurrency) {
        Money baseMoney = createMoney(basePrice, baseCurrency);
        BigDecimal exchangeRate = exchangeBoard.getExchangeRateFor(baseMoney, Currency.valueOf(targetCurrency));
        BigDecimal targetPrice = moneyCalculator.calculate(valueOf(Double.parseDouble(basePrice)), exchangeRate);

        return createMoney(targetPrice, targetCurrency);
    }
}
