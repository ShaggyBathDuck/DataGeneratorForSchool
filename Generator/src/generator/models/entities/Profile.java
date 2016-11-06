package generator.models.entities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bartosz
 */
public class Profile {
    
    private String name;
    //rozszerzone przedmioty
    private Map<String,int[]> advancedSubjects;

    public Profile(String name) {
        this.name = name;
        this.advancedSubjects=new HashMap<>();
    }

    public void addAdvancedSubject(String name, int[]numberOfHours){
        this.advancedSubjects.put(name,numberOfHours);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, int[]> getAdvancedSubjects() {
        return advancedSubjects;
    }

    public void setAdvancedSubjects(Map<String, int[]> advancedSubjects) {
        this.advancedSubjects = advancedSubjects;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", advancedSubjects=" + advancedSubjects +
                '}';
    }
}
