package tech.pathtoprogramming.currencyconverter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tech.pathtoprogramming.currencyconverter.domain.Money;
import tech.pathtoprogramming.currencyconverter.domain.MoneyConverter;
import tech.pathtoprogramming.currencyconverter.model.CurrencyRequest;

@Controller
public class CurrencyController {

    private static final Logger log = LoggerFactory.getLogger(CurrencyController.class);

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
    public String convertSubmit(@ModelAttribute CurrencyRequest currencyRequest, Model model) {
        model.addAttribute("currencyRequest", currencyRequest);
        Money money = moneyConverter
                .convert(currencyRequest.getAmount(), currencyRequest.getStartingCurrency(), currencyRequest.getTargetCurrency());
        model.addAttribute("exchangedMoney", money);

        return "result";
    }

}
