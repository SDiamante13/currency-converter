package tech.pathtoprogramming.currencyconverter.domain;

import java.math.BigDecimal;

public class CurrencyExchangeBoard implements ExchangeBoard {


    // TODO: call the fixer API when you are ready to integrate with the real API
    // TODO: Endpoint to get exchange rate - https://api.apilayer.com/fixer/latest?symbols=EUR&base=USD
    // TODO: Must pass in a header called apikey with the value of your api key when you sign up for free - https://apilayer.com/marketplace/fixer-api
    @Override
    public BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency) {
        throw new UnsupportedOperationException("need to implement");
    }
}

