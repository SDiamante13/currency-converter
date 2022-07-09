package tech.pathtoprogramming.currencyconverter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.pathtoprogramming.currencyconverter.domain.CurrencyExchangeBoard;
import tech.pathtoprogramming.currencyconverter.domain.ExchangeBoard;
import tech.pathtoprogramming.currencyconverter.domain.FakeCurrencyExchangeBoard;

@Configuration
public class CurrencyConfig {

    @Bean
    public ExchangeBoard fakeExchangeBoard() {
        return new FakeCurrencyExchangeBoard();
    }

    @Bean
    public ExchangeBoard currencyExchangeBoard() {
        return new CurrencyExchangeBoard();
    }
}
