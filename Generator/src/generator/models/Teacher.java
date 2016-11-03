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
    private final static int MIN_TEACHER_AGE=23;
    private final static int MAX_TEACHER_AGE=67;
    Random random = new Random();
    public Teacher(PersonalDataGenerator pdGenerator) {
        super(MIN_TEACHER_AGE,MAX_TEACHER_AGE,pdGenerator);
        academicDegree = generateAcademicDegree(LocalDate.now().getYear()-this.getDayOfBirth().getYear());
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

    private String generateAcademicDegree(int teacherAge){
        int chancesForTitle=random.nextInt(100);
        if(teacherAge>30 && chancesForTitle<1)
            return "profesor";
        else if(teacherAge>26 && chancesForTitle<4)
            return "doktor habilitowany";
        else if(teacherAge>26 && chancesForTitle<10)
            return "doktor";
        else if(teacherAge>24 && chancesForTitle<20)
            return "magister inżynier";
        else if(teacherAge>24 && chancesForTitle<35)
            return "magister";
        else if(chancesForTitle<55)
            return "inżynier";
        else
            return "licencjat";
    }
    private LocalDate generateJobStart(){
        int minimumYear=this.getDayOfBirth().getYear()+MIN_TEACHER_AGE;
        int year=random.nextInt(LocalDate.now().getYear()-minimumYear)+minimumYear;
        return LocalDate.of(year,9,1);
    }
    public String toString(){
        return super.toString()+" "+ academicDegree+" "+ jobStart;

    }
}