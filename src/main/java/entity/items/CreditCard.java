package entity.items;

public class CreditCard {

    private Long cardNumber;
    private Integer nrPIN;

    public CreditCard(Long cardNumber, Integer nrPIN) {
        this.cardNumber = cardNumber;
        this.nrPIN = nrPIN;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getNrPIN() {
        return nrPIN;
    }

    public void setNrPIN(Integer nrPIN) {
        this.nrPIN = nrPIN;
    }
}
