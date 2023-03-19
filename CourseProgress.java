import java.util.HashMap;
import java.util.UUID;

public class CourseProgress {
    
    private UUID id;
    private HashMap<String, Double> quizzes;
    private int numCompletedTopics;
    private double grade;

    public CourseProgress(UUID id, HashMap<String, Double> quizzes, int numCompletedTopics, double grade) {
        this.id = id;
        this.quizzes = quizzes;
        this.grade = grade;
        this.numCompletedTopics = numCompletedTopics;
    }
    //TODO
    public String toString() {
        return "CourseProgress";
    }

    public void calcGrade() {
        int questions = this.course.numCompletedTopics()*3;
        this.grade = this.course.score()/questions;
    }
    public void setNumCompletedTopics(){
        numCompletedTopics = this.course.numCompletedTopics();
    }
}
