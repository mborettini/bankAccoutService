package service;

import entity.device.ATM;
import entity.items.Cash;
import entity.people.Client;
import entity.documents.Confirmation;
import system.BankSystem;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CashDepositService {

    public static void makeDeposit(int place, Client client) throws InterruptedException {
        switch (place) {
            case 1:
                CashDepositService.atFacilityDeposit(client);
                break;
            case 2:
                CashDepositService.atATM(client);
                break;
        }
    }

    public static void atFacilityDeposit(Client client) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pracownik Banku: Poproszę o gotówkę do wpłaty. Jaką kwotę chce Pan zdeponować?");
        Float amount = scan.nextFloat();
        Cash cash = new Cash(amount, "PLN");
        System.out.println("Pracownik Banku: Dziękuję, już wprowadzam wpłatę do systemu.");
        boolean depositCheck = BankSystem.postDeposit(cash, client);
        TimeUnit.SECONDS.sleep(2);
        if (depositCheck) {
            Confirmation confirmation = BankSystem.printConfirmation(client, cash);
            System.out.println("Operacja zakończona powodzeniem. Trwa drukowanie potwierdzenia...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(confirmation);
        } else {
            BankSystem.printRejection();
            CashDepositService.atFacilityDeposit(client);
        }
    }

    public static void atATM(Client client) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        ATM atm = new ATM(18515694L, "Łódź", "Piłsudskiego", "96-284");
        System.out.println("Informacje o bankomacie:" + atm);
        TimeUnit.SECONDS.sleep(2);
        int PIN = client.getCreditCard().getNrPIN();
        System.out.println("Wprowadź kartę. Kiedy karta zostanie wporwadzona, podaj PIN.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Klient podaje PIN: ****");
        boolean pinCheck = BankSystem.verifyCreditCard(PIN, client);
        TimeUnit.SECONDS.sleep(2);

        if (pinCheck) {
            System.out.println("Pin poprawny.\nTwój stan konta: " + client.getAccountState() + " PLN. Wprowadź kwotę jaką chcesz wpłacić na swoje konto oraz włóż gotówkę do wpłatomatu.");
            Float amount = scan.nextFloat();
            Cash cash = new Cash(amount, "PLN");
            boolean depositCheck = BankSystem.postDeposit(cash, client);
            if (depositCheck) {
                Confirmation confirmation = BankSystem.printConfirmation(atm, client, cash);
                System.out.println("Operacja zakończona powodzeniem. Trwa drukowanie potwierdzenia...");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(confirmation);
            }
        } else {
            System.out.println("Operacja nieudana. Spróbuj ponownie.");
            BankSystem.printRejection();
            CashDepositService.atATM(client);
        }
    }

}
