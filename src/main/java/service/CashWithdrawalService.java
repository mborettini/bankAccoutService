package service;

import entity.device.BankDepositMachine;
import entity.items.Cash;
import entity.people.Client;
import entity.documents.Confirmation;
import system.BankSystem;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CashWithdrawalService {

    public static void withdrawCash(int place, Client client) throws InterruptedException {
        switch (place) {
            case 1:
                CashWithdrawalService.atFacilityWithdrawal(client);
                break;
            case 2:
                CashWithdrawalService.atBankDepositMachine(client);
                break;
        }
    }

    private static void atFacilityWithdrawal(Client client) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pracownik Banku: Poproszę o podanie kwoty jaką chciałby Pan wypłacić?");
        Float amount = scan.nextFloat();
        Cash cash = new Cash(amount, "PLN");
        System.out.println("Pracownik Banku: Dziękuję, proszę chwilę poczekać, trwa weryfikacja dostępności środków na koncie.");
        boolean accountStateCheck = BankSystem.checkAccountState(cash, client);
        TimeUnit.SECONDS.sleep(2);
        if (accountStateCheck) {
            Confirmation confirmation = BankSystem.printConfirmation(client, cash);
            System.out.println("Pracownik Banku: Środki na koncie są wystarczające. Oto Pańska gotówka w kwocie" + amount + " złotych oraz potwierdzenie:");
            System.out.println(confirmation);
        } else {
            System.out.println("Pracownik banku: Przykro mi, nie możemy udzielić Panu wypłaty w tej kwocie, proszę podać inną sumę. Oto dokument potwierdzający odmowę.");
            BankSystem.printRejection();
            CashWithdrawalService.atFacilityWithdrawal(client);
        }
    }

    private static void atBankDepositMachine(Client client) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        BankDepositMachine bdm = new BankDepositMachine(684218L, "Łódź", "Piotrkowska", "98-368");
        System.out.println("Informacje o wpłatomacie:" + bdm);
        TimeUnit.SECONDS.sleep(2);
        int PIN = client.getCreditCard().getNrPIN();
        System.out.println("Wprowadź kartę. Kiedy karta zostanie wporwadzona, podaj PIN.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Klient podaje PIN: ****");
        boolean pinCheck = BankSystem.verifyCreditCard(PIN, client);
        TimeUnit.SECONDS.sleep(2);

        if (pinCheck) {
            System.out.println("Pin poprawny.\nTwój stan konta: " + client.getAccountState() + " PLN. Wprowadź kwotę jaką chcesz wyłacić.");
            Float amount = scan.nextFloat();
            Cash cash = new Cash(amount, "PLN");
            boolean accountStateCheck = BankSystem.checkAccountState(cash, client);
            if (accountStateCheck) {
                Confirmation confirmation = BankSystem.printConfirmation(bdm, client, cash);
                System.out.println("Operacja zakończona powodzeniem. Odbierz gotówkę. Trwa drukowanie potwierdzenia...");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(confirmation);
            }
        } else {
            System.out.println("Operacja nieudana. Spróbuj ponownie.");
            BankSystem.printRejection();
            CashWithdrawalService.atBankDepositMachine(client);
        }
    }

}
