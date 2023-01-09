package tech.pathtoprogramming.currencyconverter.controller;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tech.pathtoprogramming.currencyconverter.domain.MoneyConverter;
import tech.pathtoprogramming.currencyconverter.model.CurrencyRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static tech.pathtoprogramming.currencyconverter.domain.Currency.EUR;
import static tech.pathtoprogramming.currencyconverter.domain.Currency.USD;
import static tech.pathtoprogramming.currencyconverter.domain.Money.createMoney;

@WebMvcTest(CurrencyController.class)
class CurrencyControllerTest {

    @MockBean
    MoneyConverter mockMoneyConverter;

    @Autowired
    MockMvc mockMvc;

    @Test
    void homePageHasDefaults() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.model().attribute("currencyRequest", new CurrencyRequest(USD.name(), EUR.name(), "100.00")));
    }

    @Test
    void convertPageDisplaysExchangedMoney() throws Exception {
        BDDMockito.given(mockMoneyConverter.convert("100.00", USD.name(), EUR.name()))
                        .willReturn(createMoney("96.00", EUR.name()));

        mockMvc.perform(MockMvcRequestBuilders.post("/convert")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("startingCurrency", USD.name())
                        .param("targetCurrency", EUR.name())
                        .param("amount", "100.00")
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("result"))
                .andExpect(MockMvcResultMatchers.model().attribute("exchangedMoney",
                        createMoney("96.00", EUR.name())));
    }
}
