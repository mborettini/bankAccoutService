package entity.items;

public class Cash {

    private Float amount;
    private String currency;

    public Cash(Float amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
