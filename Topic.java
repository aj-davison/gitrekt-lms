import java.util.ArrayList;

public class Topic {
    private ArrayList<Subtopic> subtopics;
    private ArrayList<Comment> comments;
    private String name;
    private Difficulty difficulty;
    private Quiz quiz;
    private boolean complete;

    public Topic(ArrayList<Subtopic> subtopics, String name, Difficulty difficulty, Quiz quiz){

    }
    public boolean completionStatus(){
        return true;
    }
    public String displayGrade(){
        return "";
    }
    public String toString(){
        return "";
    }
    public void addComment(Comment comment){

    }
    public void addQuiz(Quiz quiz){

    }
    public void addSubtopic(Subtopic subtopic){
        
    }
}
