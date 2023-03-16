import java.util.ArrayList;

public class Topic {
    private ArrayList<Subtopic> subtopics;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private String name;
    private Quiz quiz;
    private Difficulty difficulty;
    private boolean complete;
    private int position = 0;

    public Topic(ArrayList<Subtopic> subtopics, String name, Difficulty difficulty, Quiz quiz){
        this.subtopics = subtopics;
        this.name = name;
        this.difficulty = difficulty;
        this.quiz = quiz;
        this.complete = false;

    }
    public boolean completionStatus(){
        boolean result;
        if(!hasNext()){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    public Subtopic nextSubtopic(){
        if(!hasNext()){
            return null;
        }
        Subtopic subtopic = subtopics.get(position);
        return subtopic;
    }
    public boolean hasNext(){
        return subtopics.get(position) != null && position < subtopics.size();
    }
    //TODO
    public String displayGrade(){
        return "";
    }
    //TODO
    public String toString(){
        return "";
    }
    public void addComment(Comment comment){
        comments.add(comment);
    }
    public void addQuiz(Quiz quiz){
        this.quiz = quiz;
    }
    public void addSubtopic(Subtopic subtopic){
        subtopics.add(subtopic);
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
