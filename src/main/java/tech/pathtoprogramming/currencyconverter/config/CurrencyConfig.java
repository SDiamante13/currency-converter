package tech.pathtoprogramming.currencyconverter.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import tech.pathtoprogramming.currencyconverter.domain.CurrencyExchangeBoard;
import tech.pathtoprogramming.currencyconverter.domain.ExchangeBoard;
import tech.pathtoprogramming.currencyconverter.domain.FakeCurrencyExchangeBoard;

@Configuration
public class CurrencyConfig {

    @Qualifier("fakeExchangeBoard")
    @Bean
    public ExchangeBoard fakeExchangeBoard() {
        return new FakeCurrencyExchangeBoard();
    }
    @Bean
    // rest template is a prototype bean this makes it singleton so se can inject in controllers
    public RestTemplate template(RestTemplateBuilder builder){

        return builder.build();
    }
    public ObjectMapper mapper(){

        return new ObjectMapper();
    }

    @Qualifier("RealExchangeBoard")
    @Bean
    CurrencyExchangeBoard exchangeBoard() {

        return new CurrencyExchangeBoard(template(new RestTemplateBuilder()),mapper());
    }


}
