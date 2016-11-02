package generator.models;

import generator.DataReader;
import generator.PersonalDataGenerator;

import java.util.*;

/**
 *
 * @author Bartosz
 */
public class School {
    
    private List<Subject> subjectList;
    private List<Profile> profilesList;
    private List<Teacher> teacherList;
    private Set<Pesel> pesels;
    private PersonalDataGenerator personalDataGenerator;

    public School() {
        personalDataGenerator = new PersonalDataGenerator();
        profilesList=generateProfilesList();
        generateSubjectList();
        pesels=new HashSet<>();
        teacherList=generateTeacherListAddThemToPesels(this.subjectList, pesels, personalDataGenerator);




    }

    private List<Teacher> generateTeacherListAddThemToPesels(final List<Subject> subjectList, Set<Pesel> pesels, PersonalDataGenerator personalDataGenerator){
        ArrayList<Teacher> teachers= new ArrayList<>(50);
        Random random= new Random();
        subjectList.forEach(subject -> {
            int numberOfSubjectsTeachers= random.nextInt(9) +1;
            for (int i=0; i<numberOfSubjectsTeachers; i++){
                Teacher addedTeacher=new Teacher(personalDataGenerator);
                if(!pesels.contains(addedTeacher.getPesel()))
                    teachers.add(addedTeacher);
                else
                    i--;
            }
        });
        return teachers;
    }

    private List<Profile> generateProfilesList(){
        return DataReader.readProfiles();
    }


    private void generateSubjectList() {
        subjectList = new ArrayList<>();
        getSubjectList().add(new Subject("Matematyka", "język polski"));
        getSubjectList().add(new Subject("Język polski", "język polski"));
        getSubjectList().add(new Subject("Wychowanie fizyczne", "język polski"));
        getSubjectList().add(new Subject("English", "język angielski"));

        getSubjectList().add(new Subject("Fizyka", "język polski"));
        getSubjectList().add(new Subject("Biologia", "język polski"));
        getSubjectList().add(new Subject("Geografia", "język polski"));
        getSubjectList().add(new Subject("Chemia", "język polski"));

        getSubjectList().add(new Subject("Wiedza o kulturze", "język polski"));
        getSubjectList().add(new Subject("Historia", "język polski"));
        getSubjectList().add(new Subject("Wiedza o społeczeństwie", "język polski"));
        getSubjectList().add(new Subject("Podstawy przedsiębiorczości", "język polski"));

        getSubjectList().add(new Subject("Informatyka", "język polski"));
        getSubjectList().add(new Subject("Deutsch", "język niemiecki"));
        getSubjectList().add(new Subject("русский", "język rosyjski"));
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public List<Profile> getProfilesList() {
        return profilesList;
    }
}
