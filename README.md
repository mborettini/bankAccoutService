## Table of contents
* [Cel aplikacji](#Cel aplikacji)
* [Technologie](#Technologie)
* [Prezentacja](#Prezentacja)

## Cel aplikacji
Aplikacja jest realizacją stworzonych wcześniej diagramów UML:
* Diagramów przypadków użycia
* Diagramu klas
* Diagramów aktywności
* Diagramów sekwencji

## Technologie
Projekt utworzony został przy użyciu:
* Java version: 11.0.12
* Maven version: 4.0.0
* PlantUML

## Prezentacja
Aby uruchomić aplikację należy wystartować klasę 'Main'.

W rezultacie na ekranie pojawi się możliwość wyboru czy usługi bankowe mają zostać obsłużone online czy stacjonarnie w placówce banku. Następnie wyświetlone zostaną możliwe do wyboru usługi. Zaimplementowany algorytm prowadzi Użytkownika krok po krou przez procesy bankowe:

```
Jeśli znajdujesz się w placówce banku wpisz '1', jeśli chcesz załatwić sprawę online/za pośrednictwem bankomatu wpisz '2'.
1
Dane klienta:
Numer klienta: 126854, stan konta: 10000.0 PLN, nrPESEL: 90050608342, Imię: 'Jakub', Drugie imię: 'Julian', Nazwisko: 'Kowalczyk', Data urodzenia: 1990-05-06, E-mail: 'jakub.kowalczyk@gmail.com', Telefon: 506406660, Miasto: 'Łódź', Adres: 'Sienkiewicza 5A m. 6', Kod pocztowy: '93-340'.

Dzień dobry. Nazywam się Joanna Pasikowska, Doradca klienta. W czym mogę pomóc? Proszę wskazać numer usługi z jakiej chciałby Pan skorzystać.
1: Wziąć pożyczkę
2: Dokonać przelewu środków
3: Otrzymać pomoc lub informację
4: Wpłacić gotówkę
5: Wypłacić gotówkę
1
Pracownik Banku:
Proszę podać następujące informacje
Kwota pożyczki:
5000
...
```