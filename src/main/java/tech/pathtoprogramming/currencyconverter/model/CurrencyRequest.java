package tech.pathtoprogramming.currencyconverter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CurrencyRequest that = (CurrencyRequest) o;

        if (startingCurrency != null ? !startingCurrency.equals(that.startingCurrency) : that.startingCurrency != null) {
            return false;
        }
        if (targetCurrency != null ? !targetCurrency.equals(that.targetCurrency) : that.targetCurrency != null) {
            return false;
        }
        return amount != null ? amount.equals(that.amount) : that.amount == null;
    }

    @Override
    public int hashCode() {
        int result = startingCurrency != null ? startingCurrency.hashCode() : 0;
        result = 31 * result + (targetCurrency != null ? targetCurrency.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyRequest{" +
                "startingCurrency='" + startingCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
