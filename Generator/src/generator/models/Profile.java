package generator.models;

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
    
}
