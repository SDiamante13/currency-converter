package tech.pathtoprogramming.currencyconverter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.pathtoprogramming.currencyconverter.domain.ExchangeBoard;
import tech.pathtoprogramming.currencyconverter.domain.FakeCurrencyExchangeBoard;

@Configuration
public class CurrencyConfig {

    @Bean
    public ExchangeBoard fakeExchangeBoard() {
        return new FakeCurrencyExchangeBoard();
    }
}
