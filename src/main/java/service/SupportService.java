package service;

import entity.people.Client;
import entity.people.HelpLineEmployee;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SupportService {

    public static void receiveHelp(int place, Client client) throws InterruptedException {
        switch (place) {
            case 1:
                System.out.println("Pracownik Banku: Proszę podać numer PESEL celem weryfikacji.");
                break;
            case 2:
                HelpLineEmployee hEmployee = new HelpLineEmployee(
                        65165L,
                        "Kamil",
                        "Nowak",
                        "Doradca klienta"
                );
                System.out.println("Dzień dobry. Nazywam się " + hEmployee + " Proszę podać numer PESEL celem weryfikacji.");
                break;
        }

        Scanner scan = new Scanner(System.in);
        int response;
        String problem;
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Klient: Oczywiście. Mój numer PESEL to: " + client.getNrPESEL() + ".");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Pracownik Banku: Dziękuję, zgadza się.");
        do {
            System.out.println("Jak mogę pomóc?");
            scan.nextLine();
            problem = scan.nextLine();
            System.out.println("Pracownik Banku: Rozumiem. Rozwiązanie Pańskiego problemu zostało wyświetlone na ekranie. Czy potrzebuje Pan dalszych instrukcji? Tak - wpisz '1', nie - wpisz '2'");
            TimeUnit.SECONDS.sleep(2);
            response = scan.nextInt();
        } while (response != 2);
        System.out.println("Pracownik Banku: Dziękuję. W razie jakichkolwiek dalszych wątpliwości zapraszam do kontaktu. Miłego dnia.");
    }

}
