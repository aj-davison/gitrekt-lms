import java.util.*;

public class Course {
    
    private ArrayList<Topic> topics;
    private String title;
    private String description;
    private UUID id;

    public Course(ArrayList<Topic> topics, String title, String description) {

    }

    public Course(UUID id, ArrayList<Topic> topics, String title, String description) {

    }

    public String toString() {
        return "";
    }

    public void addTopic(Topic topic) {
        
    }

    public String getID() {
        if(id == null)
            return null;
        else
            return this.id.toString();
    }

    public String getTitle() {
        if(title == null)
            return null;
        else
            return this.title;
    }

    public String getDescription() {
        if(description == null)
            return null;
        else
            return this.description;
    }

}
