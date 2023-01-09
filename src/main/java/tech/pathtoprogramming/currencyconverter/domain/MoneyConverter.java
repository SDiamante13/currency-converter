package tech.pathtoprogramming.currencyconverter.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class MoneyConverter {
    private final ExchangeBoard exchangeBoard;
    private final MoneyCalculator moneyCalculator;

    public MoneyConverter(  @Qualifier("fakeExchangeBoard")
                          ExchangeBoard exchangeBoard, MoneyCalculator moneyCalculator) {
        this.exchangeBoard = exchangeBoard;
        this.moneyCalculator = moneyCalculator;
    }

    public Money convert(String basePrice,
                         String baseCurrency,
                         String targetCurrency) throws IOException {
        Money baseMoney = Money.createMoney(basePrice, baseCurrency);
        BigDecimal exchangeRateForBaseCurrency
                = exchangeBoard.getExchangeRateFor(baseMoney,
                Currency.valueOf(targetCurrency));

        BigDecimal calculatedMoney
                = moneyCalculator.calculate(BigDecimal.
                        valueOf(Long.parseLong(basePrice)),
                exchangeRateForBaseCurrency);

        //  UnsupportedOperationException("need to implement");
        return new Money(calculatedMoney, Currency.valueOf(targetCurrency));
    }
}