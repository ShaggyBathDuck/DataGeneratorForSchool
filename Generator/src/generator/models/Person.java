package generator.models;

import generator.PersonalDataGenerator;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author Dawid
 */
public class Person {
    private Pesel pesel;
    private String name;
    private String surname;
    private LocalDate dayOfBirth;
    private Random random;

    public Person(int minimumAge, int maximumAge, PersonalDataGenerator pdGenerator) {
        random=new Random();
        boolean isMan=random.nextBoolean();
        this.dayOfBirth=this.generateDayOfBirth(minimumAge, maximumAge);
        this.pesel = new Pesel(dayOfBirth, isMan);
        this.name = pdGenerator.getName(isMan);
        this.surname = pdGenerator.getSurname(isMan);
    }

    public Pesel getPesel() {
        return pesel;
    }

    public void setPesel(Pesel pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    private LocalDate generateDayOfBirth(int minAge, int maxAge){
        int year=random.nextInt(maxAge-minAge)+2016-maxAge;
        int day=random.nextInt(365)+1;
        if(((year%4==0)&& (year % 100!=0))||(year %400==0))
            day=random.nextInt(366)+1;
        return LocalDate.ofYearDay(year,day);
    }
    public String toString(){
        return pesel.toString()+" "+name+" "+ surname+" " +dayOfBirth;
    }
}