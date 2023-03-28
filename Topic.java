import java.util.ArrayList;

public class Topic {
    private ArrayList<Subtopic> subtopics;
    private ArrayList<Comment> comments; 
    private String name;
    private Quiz quiz;
    private int position;

    public Topic(ArrayList<Subtopic> subtopics, String name, Quiz quiz){
        this.subtopics = subtopics;
        this.name = name;
        this.quiz = quiz;
        comments = new ArrayList<Comment>();
        this.position = 0;
    }

    public Topic(ArrayList<Subtopic> subtopics, ArrayList<Comment> comments, String name,Quiz quiz){
        this.subtopics = subtopics;
        this.comments = comments;
        this.name = name;
        this.quiz = quiz;
        this.position =0;
    }

    public boolean equals(Topic topic){
        boolean result = false;
        boolean subtopicCheck = false;
        int position = 0;
        int numMatchingSubtopics = 0;
        for(Subtopic subtopic : subtopics){
            if(subtopic.equals(topic.getSubTop().get(position))){
                numMatchingSubtopics++;
            }
            position++;
        }
        if(numMatchingSubtopics == subtopics.size()){
            subtopicCheck = true;
        }
        if(subtopicCheck &&
        this.name.equals(topic.getName()) &&
        this.quiz.equals(topic.getQuiz())){
            result = true;
        }
        return result;
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
        position++;
        return subtopic;
    }

    public boolean hasNext(){
        return subtopics.get(position) != null && position < subtopics.size();
    }

    public String toString(){
        String result = "";
        result += this.name+"\n";
        result += this.nextSubtopic().toString();
        position++;
        return result;
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
    
    public String getName() {
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
