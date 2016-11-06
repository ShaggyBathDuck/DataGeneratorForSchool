package generator.models.entities;

import generator.PersonalDataGenerator;
import generator.models.Person;

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
    private Subject teachingSubject;
    private int numberOfTeachingClass;

    public Teacher(PersonalDataGenerator pdGenerator, Subject teachingSubject) {
        super(MIN_TEACHER_AGE,MAX_TEACHER_AGE,pdGenerator);
        academicDegree = generateAcademicDegree(LocalDate.now().getYear()-this.getDayOfBirth().getYear());
        jobStart=generateJobStart();
        this.teachingSubject=teachingSubject;
        this.numberOfTeachingClass=0;
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

    public Subject getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(Subject teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    public int getNumberOfTeachingClass() {
        return numberOfTeachingClass;
    }

    public void setNumberOfTeachingClass(int numberOfTeachingClass) {
        this.numberOfTeachingClass = numberOfTeachingClass;
    }
    public void increaseNumberOfTeachingClass() {
        this.numberOfTeachingClass ++;
    }

}