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
   

    public Course(String title, String description, Difficulty difficulty, UUID authorID) {
        this.title = title;
        this. description =  description;
        ArrayList<Topic> topics = new ArrayList<>();
        this.difficulty = difficulty;

    }

    public Course(UUID id, ArrayList<Topic> topics, String title, String description, Difficulty difficulty, UUID authorID) {
        this.id = id;
        this.topics = topics;
        this.title = title;
        this.description = description;
        this.authorID = authorID;
        this.difficulty = difficulty;
    }
    public int score(){
        int score = 0;
        for(Topic topic : topics){
            score += topic.score();
        }
        return score;
    }
    //TODO
    public String toString() {
        return "";
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
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

    public ArrayList<Student> getStudents(){
        if(students != null){
            students = new ArrayList<Student>();
            return students;
        }
        else
            return null;
    }

    public ArrayList<Topic> getTopics(){
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
