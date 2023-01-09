package tech.pathtoprogramming.currencyconverter.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.UNNECESSARY;
import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.currencyconverter.domain.Currency.*;

class EndToEndTest {

    private final FakeCurrencyExchangeBoard fakeCurrencyExchangeBoard = new FakeCurrencyExchangeBoard();
    private final MoneyCalculator moneyCalculator = new MoneyCalculator();
    private final MoneyConverter moneyConverter = new MoneyConverter(fakeCurrencyExchangeBoard, moneyCalculator);

    @DisplayName("given 100 USD at an exchange rate of 0.96 will return 96 Euros")
    @Test
    void happyPath() throws IOException {
        Money expectedMoney = new Money(valueOf(96.00).setScale(2, UNNECESSARY), EUR);

        Money actualMoney = moneyConverter.convert("100", USD.name(), EUR.name());

        assertThat(actualMoney).isEqualTo(expectedMoney);
    }
}

