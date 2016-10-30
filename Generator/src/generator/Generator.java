package generator;

import generator.models.School;
import generator.models.Subject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Bartosz
 */
public class Generator {

    public static void main(String[] args) throws FileNotFoundException {
        
        School school = new School();
        generateSQLCreate();
        generateSQLInsert(school);
    }
    
    private static void generateSQLCreate() throws FileNotFoundException{
        PrintStream SQLfile = new PrintStream(new FileOutputStream("CREATE.sql"));

        SQLfile.println("CREATE TABLE Przedmiot (Nazwa przedmiotu varchar(20) NOT NULL, Język prowadzenia varchar(20));\n" +
                "CREATE TABLE Klasa (ID int NOT NULL AUTO_INCREMENT, Rok rozpoczęcia int, Nazwa varchar(1), Profil varchar(30));\n" +
                "CREATE TABLE Nauczyciel (PESEL varchar(11) NOT NULL, Imię varchar(20), Nazwisko varchar(30), Stopień naukowy varchar(20), Rozpoczęcie pracy Date);\n" +
                "CREATE TABLE Uczeń (PESEL varchar(11) NOT NULL, FK_Klasa int, Imię varchar(20), Nazwisko varchar(30), Adres varchar(150), Data urodzenia Date);\n" +
                "CREATE TABLE Realizacja przedmiotu (ID int NOT NULL AUTO_INCREMENT, FK_Przedmiot varchar(20), FK_Klasa int, FK_Nauczyciel varchar(11), Tryb realizacji varchar(11), Ilość godzin tygodniowo int);\n" +
                "CREATE TABLE Wystawienie oceny (ID int NOT NULL AUTO_INCREMENT, FK_Uczeń varchar(11), FK_RealizacjaPrzedmiotu varchar(20), Ocena int, Data wystawienia Date);");

        SQLfile.close();
    }
    
    private static void generateSQLInsert(School school) throws FileNotFoundException {
        PrintStream SQLfile = new PrintStream(new FileOutputStream("INSERT.sql"));
        
        generateInsertSubjectSQL(school, SQLfile);
        
        SQLfile.close();
    }
    
    private static void generateInsertSubjectSQL(School school, PrintStream SQLfile) {
        for (Subject subject : school.getSubjectList()) {
            SQLfile.println("INSERT INTO Przedmiot (Nazwa przedmiotu, Język prowadzenia)"
                    + " VALUES ('" + subject.getName() + "', '" + subject.getLanguage() + "');");
        }
    }    
}
