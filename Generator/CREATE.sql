CREATE TABLE Przedmiot (Nazwa przedmiotu varchar(20) NOT NULL, Język prowadzenia varchar(20));
CREATE TABLE Klasa (ID int NOT NULL AUTO_INCREMENT, Rok rozpoczęcia int, Nazwa varchar(1), Profil varchar(30));
CREATE TABLE Nauczyciel (PESEL varchar(11) NOT NULL, Imię varchar(20), Nazwisko varchar(30), Stopień naukowy varchar(20), Rozpoczęcie pracy Date);
CREATE TABLE Uczeń (PESEL varchar(11) NOT NULL, FK_Klasa int, Imię varchar(20), Nazwisko varchar(30), Adres varchar(150), Data urodzenia Date);
CREATE TABLE Realizacja przedmiotu (ID int NOT NULL AUTO_INCREMENT, FK_Przedmiot varchar(20), FK_Klasa int, FK_Nauczyciel varchar(11), Tryb realizacji varchar(11), Ilość godzin tygodniowo int);
CREATE TABLE Wystawienie oceny (ID int NOT NULL AUTO_INCREMENT, FK_Uczeń varchar(11), FK_RealizacjaPrzedmiotu varchar(20), Ocena int, Data wystawienia Date);
