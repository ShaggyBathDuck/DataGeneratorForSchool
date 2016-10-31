package generator.models;

import generator.PersonalDataGenerator;

import java.time.LocalDate;

/**
 * Created by Dawid on 2016-10-30.
 */
public class Student extends Person {
    private SchoolClass schoolClass;
    private String address;

    public Student(PersonalDataGenerator pdGenerator, SchoolClass schoolClass) {
        super(14+ LocalDate.now().getYear()-schoolClass.getStartYear(),15+ LocalDate.now().getYear()-schoolClass.getStartYear(),pdGenerator);
        this.schoolClass=schoolClass;
        address= pdGenerator.getStreet() + " " + pdGenerator.getHouseNumber() + " "+ pdGenerator.getCity();
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    @Override
    public String toString() {
        return super.toString() + " "+ schoolClass.toString() + " " + address;
    }
}