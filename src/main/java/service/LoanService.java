package service;

import entity.documents.Application;
import entity.people.Client;
import system.BankSystem;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LoanService {

    public static void takeOutALoan(int place, Client client) throws InterruptedException {
        switch (place) {
            case 1:
                LoanService.atFacilityLoan(client);
                break;
            case 2:
                LoanService.internetLoan(client);
                break;
        }
    }

    public static void internetLoan(Client client) throws InterruptedException {
        System.out.println("Wypełnij wniosek o pożyczkę.");
        Application application = LoanService.submitApplication(client);
        String decision = BankSystem.verifyApplication(application);
        System.out.println("Czekaj...");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Decyzja: " + decision);
        if (decision.matches("ODMOWA")) {
            System.out.println("Niestety pożyczka nie może zostać udzielona. Spróbuj złożyć wniosek ponownie zmieniając kryteria.");
        } else {
            System.out.println("Gratulacje! Pożyczka w kwocie " + application.getAmount() + " została przyznana. Wypłata środków została zlecona\nNa Twoj adres email wysłaliśmy dokumenty pożyczki.");
        }
    }

    public static void atFacilityLoan(Client client) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pracownik Banku:\nProszę podać następujące informacje");
        Application application = LoanService.submitApplication(client);
        System.out.println("Pracownik Banku:\nDziękuję. Wniosek został przesłany do weryfikacji. Decyzja będzie znana lada moment.");
        TimeUnit.SECONDS.sleep(1);
        String decision = BankSystem.verifyApplication(application);
        System.out.println("Czekaj...");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Decyzja: " + decision);
        if (decision.matches("ODMOWA")) {
            System.out.println("Pracownik Banku:\nNiestety nie możemy udzielić pożyczki na wskazaną kwotę.\nCzy życzy Pan sobie złożyć wniosek ponownie, zmieniając kryteria? Tak - wpisz '1', nie - wpisz '2'.");
            int response = scan.nextInt();
            if (response == 1) {
                LoanService.atFacilityLoan(client);
            } else {
                System.out.println("Pracownik Banku:\nRozumiem, gdyby zmienił Pan zdanie, zapraszam ponownie");
            }
        } else {
            System.out.println("Pracownik Banku:\nGratuluję, pożyczka w kwocie " + application.getAmount() + " została przyznana. Wypłata środków została zlecona.");
        }
    }

    public static Application submitApplication(Client client) {
        Scanner scan = new Scanner(System.in);
        Application application = new Application(1L);
        application.setFirstName(client.getFirstName());
        application.setMiddleName(client.getMiddleName());
        application.setLastName(client.getLastName());
        application.setNrPESEL(client.getNrPESEL());
        application.setDateOfBirth(String.valueOf(client.getDateOfBirth()));
        System.out.println("Kwota pożyczki:");
        application.setAmount(scan.nextLong());
        System.out.println("Miesięczny dochód (średnia z ostatnich 3 miesięcy):");
        application.setEarings(scan.nextLong());
        System.out.println("Miesięczna średnia kwota wydatków i zobowiązań:");
        application.setSpending(scan.nextLong());
        return application;
    }
}
