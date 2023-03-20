import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CourseProgress {
    
    private UUID id;
    private ArrayList<Double> grades;
    private double grade;
    //private int numCompletedTopics;

    public CourseProgress(UUID id, ArrayList<Double> grades) {
        this.id = id;
        this.grades = grades;
        //this.numCompletedTopics = numCompletedTopics;
    }
    
    //TODO
    public String toString() {
        return "CourseProgress";
    }

    public void calcGrade() {
        int questions = this.grades.size();
        for(double score : grades) {
            this.grade += score;
        }
        this.grade /= questions;
    }

    public Double getGrades(){
        //ArrayList<Double> grades = new ArrayList<Double>();
        //TODO
        return this.grade;        
    }

    public String getID() {
        return this.id.toString();
    }
    public void setNumCompletedTopics(){
        //numCompletedTopics = this.course.numCompletedTopics();
    }
}
