package service;

import entity.people.Client;
import entity.documents.Transfer;

import java.util.Scanner;

public class TransferService {

    public static void orderTransfer(int place, Client client) {
        switch (place) {
            case 1:
                TransferService.atFacilityTransfer(client);
                break;
            case 2:
                TransferService.internetTransfer(client);
                break;
        }
    }

    public static void internetTransfer(Client client) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Twój stan konta: " + client.getAccountState() + " PLN. Podaj informacje o przelewie:");
        Transfer transfer = TransferService.createTransfer();
        if (transfer.getAmount() > client.getAccountState()) {
            System.out.println("Brak wystarczającej ilości środków na koncie aby zrealizować przelew. Spróbuj ponownie zmieniając kwotę przelewu lub zasil konto.");
        } else {
            System.out.println("Czy na pewno chcesz dokonać " + transfer + "? Tak - wpisz '1', Anuluj - wpisz '2'.");
            int response = scan.nextInt();
            switch (response) {
                case 1:
                    Float accountState = client.getAccountState() - transfer.getAmount();
                    System.out.println("Przelew został zrealizowany. Obecny stan konta to " + accountState + " PLN.");
                    break;
                case 2:
                    break;
            }
        }
    }

    public static void atFacilityTransfer(Client client) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pracownik Banku:\nPański stan konta wynosi " + client.getAccountState() + " PLN. Proszę podać następujące informacje do przelewu:");
        Transfer transfer = TransferService.createTransfer();
        if (transfer.getAmount() > client.getAccountState()) {
            System.out.println("Pracownik Banku:\nPrzykro mi, nie ma Pan wystarczającej ilości środków na koncie aby zrealizować przelew. Czy chce Pan zmienić kwotę? Tak - wpisz '1', nie - wpisz '2'.");
            int response = scan.nextInt();
            if (response == 1) {
                TransferService.atFacilityTransfer(client);
            } else {
                System.out.println("Pracownik Banku:\nRozumiem, gdyby zmienił Pan zdanie, zapraszam ponownie");
            }
        } else {
            Float accountState = client.getAccountState() - transfer.getAmount();
            System.out.println("Pracownik Banku:\nPrzelew został zrealizowany. Pański stan konta wynosi " + accountState + " PLN.");
        }
    }

    public static Transfer createTransfer() {
        Scanner scan = new Scanner(System.in);
        Transfer transfer = new Transfer();
        System.out.println("Nazwa odbiorcy:");
        transfer.setRecipientName(scan.nextLine());
        System.out.println("Numer konta bankowego odbiorcy:");
        transfer.setRecipientBankAccount(scan.nextLine());
        System.out.println("Tytuł przelewu:");
        transfer.setTitle(scan.nextLine());
        System.out.println("Kwota przelewu:");
        transfer.setAmount(scan.nextLong());
        return transfer;
    }

}
