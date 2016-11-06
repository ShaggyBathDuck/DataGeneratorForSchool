package generator.models.entities;

/**
 *
 * @author Bartosz
 */
public class Subject {
    
    private String name;
    private String language;

    public Subject(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}