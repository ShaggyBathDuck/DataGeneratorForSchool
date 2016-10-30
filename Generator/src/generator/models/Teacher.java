package generator.models;

import generator.PersonalDataGenerator;

import java.time.LocalDate;
import java.util.Random;

/**
 * Created by Dawid on 2016-10-30.
 */
public class Teacher extends Person {
    private String academicDegree;
    private LocalDate jobStart;
    private int minAge;
    Random random = new Random();
    public Teacher(PersonalDataGenerator pdGenerator) {
        super(23,67,pdGenerator);
        minAge=27;
        academicDegree = generateAcademicDegree();
        jobStart=generateJobStart();

    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public LocalDate getJobStart() {
        return jobStart;
    }

    public void setJobStart(LocalDate jobStart) {
        this.jobStart = jobStart;
    }

    private String generateAcademicDegree(){
        int chancesForTitle=random.nextInt(100);
        if(chancesForTitle<50){
            minAge=23;
            return "licencjat";
        }
        else if(chancesForTitle <70){
            minAge=23;
            return "inżynier";
        }
        else if(chancesForTitle<85) {
            minAge = 25;
            return "magister";
        }
        else if(chancesForTitle<93)
            return "doktor";
        else if(chancesForTitle<98)
            return "doktor habilitowany";
        else
            return "profesor";
    }
    private LocalDate generateJobStart(){
        int minimumYear=this.getDayOfBirth().getYear()+minAge;
        int year=random.nextInt(LocalDate.now().getYear()-minimumYear)+minimumYear;
        return LocalDate.of(year,9,1);
    }
    public String toString(){
        return super.toString()+" "+ academicDegree+" "+ jobStart;

    }
}