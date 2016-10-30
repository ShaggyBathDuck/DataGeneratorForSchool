package generator.models;

/**
 * Created by Dawid on 2016-10-30.
 */
public class SubjectRealization {
    private int ID;
    private Teacher teacher;
    private SchoolClass schoolClass;
    private Subject subject;
    private String realizationMode;
    private int numberOfHours;

    public SubjectRealization(int ID, Teacher teacher, SchoolClass schoolClass, Subject subject, String realizationMode, int numberOfHours) {
        this.ID = ID;
        this.teacher = teacher;
        this.schoolClass = schoolClass;
        this.subject = subject;
        this.realizationMode = realizationMode;
        this.numberOfHours = numberOfHours;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getRealizationMode() {
        return realizationMode;
    }

    public void setRealizationMode(String realizationMode) {
        this.realizationMode = realizationMode;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @Override
    public String toString() {
        return "SubjectRealization{" +
                "ID=" + ID +
                ", teacher=" + teacher +
                ", schoolClass=" + schoolClass +
                ", subject=" + subject +
                ", realizationMode='" + realizationMode + '\'' +
                ", numberOfHours=" + numberOfHours +
                '}';
    }
}
