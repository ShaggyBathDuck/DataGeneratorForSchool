package generator.models;

import java.util.Map;

/**
 *
 * @author Bartosz
 */
public class Profile {
    
    private String name;
    //rozszerzone przedmioty
    private Map<String,int[]> advancedSubjects;

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
}
