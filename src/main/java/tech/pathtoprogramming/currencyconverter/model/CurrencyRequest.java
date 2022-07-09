package tech.pathtoprogramming.currencyconverter.model;

public class CurrencyRequest {
    private String startingCurrency;
    private String targetCurrency;
    private String amount;

    public CurrencyRequest(String startingCurrency, String targetCurrency, String amount) {
        this.startingCurrency = startingCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
    }

    public String getStartingCurrency() {
        return startingCurrency;
    }

    public void setStartingCurrency(String startingCurrency) {
        this.startingCurrency = startingCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
