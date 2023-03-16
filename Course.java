import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class Course {
    
    private ArrayList<Topic> topics;
    private ArrayList<Student> students;
    private String title;
    private String description;
    private Difficulty difficulty;
    private UUID id; 
    private UUID authorID;
   

    public Course(ArrayList<Topic> topics, String title, String description, UUID authorID) {
    
    }

    public Course(UUID id, ArrayList<Topic> topics, String title, String description, UUID authorID) {

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

    public String getAuthorIDstring() {
        if(authorID == null)
            return null;
        else
            return this.authorID.toString();
    }

    public UUID getAuthorIDuui(){
        if(authorID == null)
        return null;
    else
        return this.authorID;

    }

    public ArrayList getStudents(){
        if(students != null){
            students = new ArrayList<Student>();
            return students;
        }
        else
            return null;
    }

    public ArrayList getTopics(){
        if(topics != null){
            topics = new ArrayList<Topic>();
            return topics;
        }
        else    
            return null;
    }

    public String getDifficulty() {
        if(difficulty != null)
            return this.difficulty.toString();
        else
            return null;
    }


   
}
