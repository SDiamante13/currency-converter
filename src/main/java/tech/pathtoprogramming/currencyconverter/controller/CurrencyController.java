package tech.pathtoprogramming.currencyconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tech.pathtoprogramming.currencyconverter.domain.Currency;
import tech.pathtoprogramming.currencyconverter.domain.Money;
import tech.pathtoprogramming.currencyconverter.domain.MoneyConverter;
import tech.pathtoprogramming.currencyconverter.model.CurrencyRequest;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
public class CurrencyController {

    private final MoneyConverter moneyConverter;

    public CurrencyController(MoneyConverter moneyConverter) {
        this.moneyConverter = moneyConverter;
    }

    @GetMapping("/home")
    public String convertPage(Model model) {
        model.addAttribute("currencyRequest", new CurrencyRequest("USD", "EUR", "100.00"));
        return "index";
    }

    @PostMapping("/convert")
    public String convertSubmit(@ModelAttribute CurrencyRequest currencyRequest,
                                Model model) throws IOException {
        model.addAttribute("currencyRequest", currencyRequest);

        String baseCurrency= currencyRequest.getStartingCurrency();
        String targetCurrency = currencyRequest.getTargetCurrency();
        String amountToConvert = currencyRequest.getAmount();
        Money convertedMoney =
                moneyConverter.convert(amountToConvert, baseCurrency, targetCurrency);
        // my determined price logs
        BigDecimal price1 = convertedMoney.getPrice();
        System.out.println("price1 = " + price1);
        model.addAttribute("exchangedMoney", convertedMoney);
        // TODO: replace this stub with a call to MoneyConverter
        //Static values bellow were replaced as shown above be money Converter
       // Money exchangedMoney = Money.createMoney("96.00", "EUR");
        return "result";
    }

}
