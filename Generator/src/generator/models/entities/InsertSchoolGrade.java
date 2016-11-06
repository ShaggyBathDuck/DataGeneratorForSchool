package generator.models.entities;

import java.time.LocalDate;

/**
 * Created by Dawid on 2016-10-30.
 */
public class InsertSchoolGrade {
    private int ID;
    private Student student;
    private SubjectRealization subjectRealization;
    private int grade;
    private LocalDate gradeDate;

    public InsertSchoolGrade(int ID, Student student, SubjectRealization subjectRealization, int grade, LocalDate gradeDate) {
        this.ID = ID;
        this.student = student;
        this.subjectRealization = subjectRealization;
        this.grade = grade;
        this.gradeDate = gradeDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectRealization getSubjectRealization() {
        return subjectRealization;
    }

    public void setSubjectRealization(SubjectRealization subjectRealization) {
        this.subjectRealization = subjectRealization;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDate getGradeDate() {
        return gradeDate;
    }

    public void setGradeDate(LocalDate gradeDate) {
        this.gradeDate = gradeDate;
    }

    @Override
    public String toString() {
        return "InsertSchoolGrade{" +
                "ID=" + ID +
                ", student=" + student +
                ", subjectRealization=" + subjectRealization +
                ", grade=" + grade +
                ", gradeDate=" + gradeDate +
                '}';
    }
}
