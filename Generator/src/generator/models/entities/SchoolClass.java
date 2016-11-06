package generator.models.entities;

import java.util.Arrays;

/**
 *
 * @author Bartosz
 */
public class SchoolClass {
    private int ID;
    private int studentsNumber;
    private int startYear;
    private char name;
    private Profile profile;
    private boolean[][] lessonsAtSchedule;
    private final static int NUMBER_OF_SCHOOL_LESSONS=8;
    private final static int NUMBER_OF_SCHOOL_DAYS=5;

    public SchoolClass(int ID, int studentsNumber, int startYear, char name, Profile profile) {
        this.ID = ID;
        this.studentsNumber = studentsNumber;
        this.startYear = startYear;
        this.name = name;
        this.profile = profile;
        lessonsAtSchedule = new boolean[NUMBER_OF_SCHOOL_LESSONS][NUMBER_OF_SCHOOL_DAYS];
        Arrays.fill(lessonsAtSchedule,false);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(int studentsNumber) {
        this.studentsNumber = studentsNumber;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
    
    public Profile getProfile() {
        return profile;
    }
    
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public boolean isLessonAtSchedule(int schoolHour, int dayOfWeek){
        return lessonsAtSchedule[schoolHour][dayOfWeek];
    }

    public void setLessonAtSchedule(int schoolHour, int dayOfWeek){
        lessonsAtSchedule[schoolHour][dayOfWeek]=true;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "ID=" + ID +
                ", studentsNumber=" + studentsNumber +
                ", startYear=" + startYear +
                ", name=" + name +
                ", profile=" + profile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchoolClass that = (SchoolClass) o;

        if (ID != that.ID) return false;
        if (startYear != that.startYear) return false;
        return name == that.name;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + startYear;
        result = 31 * result + (int) name;
        return result;
    }
}
