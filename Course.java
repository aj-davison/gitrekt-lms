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
   

    public Course(String title, String description,  Difficulty difficulty, UUID authorID) {
        this.topics = new ArrayList<Topic>();
        this.students = new ArrayList<Student>();
        this.title = title;
        this. description =  description;
        this.id = UUID.randomUUID();
        this.authorID = authorID;
        this.difficulty = difficulty;

    }
    /*
    public Course(UUID id, ArrayList<Topic> topics, String title, String description, Difficulty difficulty, UUID authorID) {
        this.topics = topics;
        this.students = new ArrayList<Student>();
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.id = id;
        this.authorID = authorID;
    } */

    public Course(UUID id, ArrayList<Topic> topics, ArrayList<Student> students, String title, String description, Difficulty difficulty, UUID authorID) {
        this.topics = topics;
        this.students = students;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.id = id;
        this.authorID = authorID;
    }
    /*
    public double grades(){
        double score = 0;
        double denom = 0;
        for(Topic topic : topics){
            score += topic.grade();
            denom+=1;
        }
        return score/denom;
    } */

    //TODO
    public String toString() {
        return "COURSE";
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public ArrayList<Student> getStudents(){
        if(students != null){
            return this.students;
        }
        else
            students = new ArrayList<Student>();
            return null;
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

    public ArrayList<Topic> getTopics(){
        if(topics != null){
            //topics = new ArrayList<Topic>();
            return this.topics;
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
