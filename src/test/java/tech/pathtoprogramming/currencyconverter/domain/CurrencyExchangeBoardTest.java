package tech.pathtoprogramming.currencyconverter.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.currencyconverter.domain.Currency.EUR;

class CurrencyExchangeBoardTest {

    public static final Money USD_MONEY =
            new Money(BigDecimal.valueOf(100), Currency.USD);
public final  CurrencyExchangeBoard currencyExchangeBoard;

    CurrencyExchangeBoardTest(CurrencyExchangeBoard currencyExchangeBoard) {
        this.currencyExchangeBoard = currencyExchangeBoard;
    }

    // TODO: You can use this test to verify your live client works for Fixer API
    // TODO: Currently is disabled due to the 100 calls per month quota that Fixer has.
  //  @Test
    @Disabled
    void liveCallToFixerAPI() throws IOException {
        BigDecimal expectedExchangeRateStart = BigDecimal.valueOf(0.9);
        BigDecimal expectedExchangeRateEnd = BigDecimal.valueOf(1.0);

        BigDecimal actualExchangeRate = currencyExchangeBoard.getExchangeRateFor(USD_MONEY, EUR);

        assertThat(actualExchangeRate).isBetween(expectedExchangeRateStart, expectedExchangeRateEnd);
    }
}