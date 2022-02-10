package entity.documents;

public class Transfer {
    private String recipientName;
    private String recipientBankAccount;
    private String title;
    private Long amount;

    public Transfer() {
    }

    public Transfer(String recipientName, String recipientBankAccount, String title, Long amount) {
        this.recipientName = recipientName;
        this.recipientBankAccount = recipientBankAccount;
        this.title = title;
        this.amount = amount;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientBankAccount() {
        return recipientBankAccount;
    }

    public void setRecipientBankAccount(String recipientBankAccount) {
        this.recipientBankAccount = recipientBankAccount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "przelew do: '" + recipientName + '\'' +
                ", na konto numer: '" + recipientBankAccount + '\'' +
                ", o tytule: '" + title + '\'' +
                ", w kwocie: " + amount + "PLN";
    }
}
