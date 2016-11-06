package generator.models;

import generator.models.entities.SchoolClass;
import generator.models.entities.SubjectRealization;

/**
 * Created by Dawid on 2016-11-06.
 */
public class SchoolLesson {
    private SubjectRealization subjectRealization;
    private SchoolClass schoolClass;
    private int numberOfDay;
    private int numberOfSchoolHour;

    public SchoolLesson(SubjectRealization subjectRealization, SchoolClass schoolClass, int numberOfDay, int numberOfSchoolHour) {
        this.subjectRealization = subjectRealization;
        this.schoolClass = schoolClass;
        this.numberOfDay = numberOfDay;
        this.numberOfSchoolHour = numberOfSchoolHour;
    }

    public SubjectRealization getSubjectRealization() {
        return subjectRealization;
    }

    public void setSubjectRealization(SubjectRealization subjectRealization) {
        this.subjectRealization = subjectRealization;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public int getNumberOfSchoolHour() {
        return numberOfSchoolHour;
    }

    public void setNumberOfSchoolHour(int numberOfSchoolHour) {
        this.numberOfSchoolHour = numberOfSchoolHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchoolLesson that = (SchoolLesson) o;

        if (numberOfDay != that.numberOfDay) return false;
        if (numberOfSchoolHour != that.numberOfSchoolHour) return false;
        return schoolClass.equals(that.schoolClass);

    }

    @Override
    public int hashCode() {
        int result = schoolClass.hashCode();
        result = 31 * result + numberOfDay;
        result = 31 * result + numberOfSchoolHour;
        return result;
    }
}
