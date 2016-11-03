package generator.models;

import generator.DataReader;
import generator.PersonalDataGenerator;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Bartosz
 */
public class School {
    
    private List<Subject> subjectList;
    private List<Profile> profilesList;
    private List<Teacher> teacherList;
    private List<SchoolClass> schoolClassList;
    private Set<Pesel> pesels;
    private PersonalDataGenerator personalDataGenerator;

    public School() {
        personalDataGenerator = new PersonalDataGenerator();
        profilesList=generateProfilesList();
        generateSubjectList();
        pesels=new HashSet<>();
        teacherList=generateTeacherListAddThemToPesels(this.subjectList, pesels, personalDataGenerator);
        schoolClassList=generateSchoolClasses(profilesList,2013);


    }
    private List<Teacher> generateTeacherListAddThemToPesels(final List<Subject> subjectList, Set<Pesel> pesels,final PersonalDataGenerator personalDataGenerator){
        ArrayList<Teacher> teachers= new ArrayList<>(50);
        Random random = new Random();
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

   private List<SchoolClass> generateSchoolClasses(final List<Profile> profilesList, int startYearOfGenerating){
       ArrayList<SchoolClass> schoolClasses=new ArrayList<>(25);
       Random random = new Random();
       int actualSchoolYear=LocalDate.now().getYear()- (LocalDate.now().getMonthValue()>9?1:0);
       int schoolClassId=1;
       for (;startYearOfGenerating<=actualSchoolYear;startYearOfGenerating++){
           int numberOfClassOnYear=random.nextInt(3)+5;
           System.out.println(numberOfClassOnYear);
           char className='A';
           Iterator profileIterator=profilesList.iterator();
           for(int i=0; i<numberOfClassOnYear;i++){
                if(profileIterator.hasNext()){
                    schoolClasses.add(new SchoolClass(schoolClassId,random.nextInt(11)+20,startYearOfGenerating,className,(Profile)profileIterator.next()));
                    className++;
                    schoolClassId++;
                }else{
                    profileIterator=profilesList.iterator();
                    i--;
                }
           }
       }
       return schoolClasses;
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

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public List<SchoolClass> getSchoolClassList() {
        return schoolClassList;
    }
}
