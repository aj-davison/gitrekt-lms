import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CourseProgress {
    
    private UUID id;
    private HashMap<String, Double> grades;
    private int numCompletedTopics;

    public CourseProgress(UUID id, HashMap<String, Double> grades, int numCompletedTopics) {
        this.id = id;
        this.grades = grades;
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

    public Double getGrades(){
        ArrayList<Double> grades= new ArrayList<Double>();
        //TODO
        return grades;        
    }

    public void setNumCompletedTopics(){
        numCompletedTopics = this.course.numCompletedTopics();
    }
}
