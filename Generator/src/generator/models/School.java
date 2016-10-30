package generator.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bartosz
 */
public class School {
    
    private List<Subject> subjectList;
    
    public School() {
        generateSubjectList();
    }
    
    private void generateSubjectList() {
        subjectList = new ArrayList();
        getSubjectList().add(new Subject("Matematyka", "język polski"));
        getSubjectList().add(new Subject("Język polski", "język polski"));
        getSubjectList().add(new Subject("Fizyka", "język polski"));
        getSubjectList().add(new Subject("Biologia", "język polski"));
        getSubjectList().add(new Subject("Wiedza o kulturze", "język polski"));
        getSubjectList().add(new Subject("Historia", "język polski"));
        getSubjectList().add(new Subject("Wiedza o społeczeństwie", "język polski"));
        getSubjectList().add(new Subject("Podstawy przedsiębiorczości", "język polski"));
        getSubjectList().add(new Subject("Geografia", "język polski"));
        getSubjectList().add(new Subject("Chemia", "język polski"));
        getSubjectList().add(new Subject("Informatyka", "język polski"));
        getSubjectList().add(new Subject("Wychowanie fizyczne", "język polski"));
        getSubjectList().add(new Subject("English", "język angielski"));
        getSubjectList().add(new Subject("Deutsch", "język niemiecki"));
        getSubjectList().add(new Subject("русский", "język rosyjski"));
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }
    
}
