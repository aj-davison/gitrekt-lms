import java.util.ArrayList;

public class Topic {
    private ArrayList<Subtopic> subtopics;
    private ArrayList<Comment> comments;
    private String name;
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
    public ArrayList<Subtopic> getSubTop() {
        if(subtopics == null){
            subtopics = new ArrayList<Subtopic>();
            return subtopics;
        }
        else
            return this.subtopics;
    }
    public Quiz getQuiz() {
        return this.quiz;
    }
    public Object getName() {
        return this.name;
    }
    public ArrayList<Comment> getComments() {
        if(comments == null) {
            comments = new ArrayList<Comment>();
            return comments;
        } 
        else
            return this.comments;
    }
}
