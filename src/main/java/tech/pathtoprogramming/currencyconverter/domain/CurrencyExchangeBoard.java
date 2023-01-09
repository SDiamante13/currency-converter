package tech.pathtoprogramming.currencyconverter.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;

public class CurrencyExchangeBoard implements ExchangeBoard {


  @Value("${apiKey}")
    String    API_KEY ;
    private final String API_ENDPOINT =
"https://api.apilayer.com/fixer/convert?to=to&from=from&amount=amount" + API_KEY;


    private final RestTemplate restTemplate ;
    private final ObjectMapper objectMapper ;

    public CurrencyExchangeBoard(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }


    // TODO: Must pass in a header called apikey
    //  with the value of your api key when you sign up for free
    //  - https://apilayer.com/marketplace/fixer-api
    @Override
    public BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency) throws IOException {

        String url = API_ENDPOINT + "&base=" + baseMoney + "&symbols=" + targetCurrency;
        String response = restTemplate.getForObject(url, String.class);
        BigDecimal exchangeRate = objectMapper.readValue(response, BigDecimal.class);
        return exchangeRate;
//
//        Request request = new Request.Builder()
//                .url(API_ENDPOINT)
//                .addHeader("apikey", API_KEY)
//                .method("GET", null  )
//
//            .build();
//        Response response = client.newCall(request).execute();
//        String responseBody = response.body().string();
//
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(responseBody, BigDecimal.class);

      // throw new UnsupportedOperationException("need to implement");
    }
}

