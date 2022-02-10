import entity.people.Client;
import entity.items.CreditCard;
import entity.people.FacilityEmployee;
import service.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Stworzenie karty kredytowej dla klienta.
        CreditCard card = new CreditCard(29454589L, 3945);

        // Stworzenie klienta, który będzie korzystał z usług bankowych.
        // Rejestreacja i logowanie nie zostały obłużone w aplikacji poniewaź nie są tak istotne z punktu widzenia diagramów UML
        Client client = new Client(
                126854L,
                10000.00F,
                90050608342L,
                "Jakub",
                "Julian",
                "Kowalczyk",
                LocalDate.of(1990, 5, 6),
                "jakub.kowalczyk@gmail.com",
                506406660L,
                "Łódź",
                "Sienkiewicza 5A m. 6",
                "93-340",
                card
        );

        // Stworzenie pracownika placówki bankowej
        FacilityEmployee fEmployee = new FacilityEmployee(
                4367248L,
                "Joanna",
                "Pasikowska",
                "Doradca klienta"
        );

        Scanner scan = new Scanner(System.in);
        HashMap<Integer, String> services = new HashMap<>(
                Map.of(
                        1, "Wziąć pożyczkę",
                        2, "Dokonać przelewu środków",
                        3, "Otrzymać pomoc lub informację",
                        4, "Wpłacić gotówkę",
                        5, "Wypłacić gotówkę"
                )
        );

        System.out.println("Jeśli znajdujesz się w placówce banku wpisz '1', jeśli chcesz załatwić sprawę online/za pośrednictwem bankomatu wpisz '2'.");
        int place = scan.nextInt();
        System.out.println("Dane klienta:\n" + client + "\n");
        switch (place) {
            case 1:
                System.out.println("Dzień dobry. Nazywam się " + fEmployee + " W czym mogę pomóc? Proszę wskazać numer usługi z jakiej chciałby Pan skorzystać.");
                break;
            case 2:
                System.out.println("Witaj " + client.getFirstName() + "!\nWybierz z jakiej usługi chciałbyś skorzystać wpisując odpowiadający jej numer:");
                break;
        }

        services.forEach((k, v) -> System.out.println((k + ": " + v)));
        int serviceNumber = scan.nextInt();
        while (!services.containsKey(serviceNumber)) {
            System.out.println("Usługa o tym numerze nie istnieje. Wpisz poprawny numer.");
            serviceNumber = scan.nextInt();
        }

        switch (serviceNumber) {
            case 1:
                LoanService.takeOutALoan(place, client);
                break;
            case 2:
                TransferService.orderTransfer(place, client);
                break;
            case 3:
                SupportService.receiveHelp(place, client);
                break;
            case 4:
                CashDepositService.makeDeposit(place, client);
                break;
            case 5:
                CashWithdrawalService.withdrawCash(place, client);
                break;
        }
    }
}
