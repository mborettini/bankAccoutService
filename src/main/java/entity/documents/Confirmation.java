package entity.documents;

import java.time.LocalDate;

public class Confirmation {

    private final Long confirmationId;
    private Long deviceId;
    private LocalDate operationDate;
    private Float amount;
    private Long clientId;
    private Float accountStateAfterOperation;

    public Confirmation(Long confirmationId, Long deviceId, LocalDate operationDate, Float amount, Long clientId, Float accountStateAfterOperation) {
        this.confirmationId = confirmationId;
        this.deviceId = deviceId;
        this.operationDate = operationDate;
        this.amount = amount;
        this.clientId = clientId;
        this.accountStateAfterOperation = accountStateAfterOperation;
    }

    public Confirmation(Long confirmationId, LocalDate operationDate, Float amount, Long clientId, Float accountStateAfterOperation) {
        this.confirmationId = confirmationId;
        this.operationDate = operationDate;
        this.amount = amount;
        this.clientId = clientId;
        this.accountStateAfterOperation = accountStateAfterOperation;
    }

    public Long getConfirmationId() {
        return confirmationId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Float getAccountStateAfterOperation() {
        return accountStateAfterOperation;
    }

    public void setAccountStateAfterOperation(Float accountStateAfterOperation) {
        this.accountStateAfterOperation = accountStateAfterOperation;
    }

    @Override
    public String toString() {
        return "Potwierdzenie:    " +
                "numer dokumentu: " + confirmationId +
                ", numer urządzenia: " + deviceId +
                ", data operacji: " + operationDate +
                ", kwota operacji: " + amount +
                " PLN, numer klienta: " + clientId +
                ", stan konta po operacji: " + accountStateAfterOperation +
                " PLN.";
    }
}
