package system;

import entity.device.Device;
import entity.documents.Application;
import entity.documents.Confirmation;
import entity.items.Cash;
import entity.people.Client;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class BankSystem {

    public static String verifyApplication(Application application) throws InterruptedException {
        System.out.println("Status: ZŁOŻONY");
        TimeUnit.SECONDS.sleep(2);
        String decision = BIK.checkCreditworthiness(application);
        return decision;
    }

    public static boolean verifyCreditCard(Integer PIN, Client client) {
        if (PIN.equals(client.getCreditCard().getNrPIN())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean postDeposit(Cash cash, Client client) {
        Float accountAfterDeposit = client.getAccountState() + cash.getAmount();
        try {
            client.setAccountState(accountAfterDeposit);
            return true;
        } catch (Exception e) {
            new Exception("Operacja nieudana. Spróbuj ponownie.");
            return false;
        }
    }

    public static boolean checkAccountState(Cash cash, Client client) {
        if (cash.getAmount() >= client.getAccountState()) {
            return true;
        }
        return false;
    }

    public static Confirmation printConfirmation(Device device, Client client, Cash cash) {
        Confirmation confirmation = new Confirmation(
                1115L,
                device.getNumber(),
                LocalDate.now(),
                cash.getAmount(),
                client.getId(),
                client.getAccountState());
        return confirmation;
    }

    public static Confirmation printConfirmation(Client client, Cash cash) {
        Confirmation confirmation = new Confirmation(
                1115L,
                LocalDate.now(),
                cash.getAmount(),
                client.getId(),
                client.getAccountState());
        return confirmation;
    }

    public static String printRejection() {
        return "Operacja zakończona niepowodzeniem. Spróbuj ponowanie.";
    }

}
