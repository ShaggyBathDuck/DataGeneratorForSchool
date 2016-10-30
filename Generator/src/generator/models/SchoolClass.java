package generator.models;

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

    public SchoolClass(int ID, int studentsNumber, int startYear, char name, Profile profile) {
        this.ID = ID;
        this.studentsNumber = studentsNumber;
        this.startYear = startYear;
        this.name = name;
        this.profile = profile;
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
}
