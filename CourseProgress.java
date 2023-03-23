import java.util.ArrayList;
import java.util.UUID;

public class CourseProgress {
    //private static CourseList courseList;
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
    public void addGrade(double grade){
        this.grades.add(grade);
    }
    public Double getGrade(){
        return this.grade;
    }
    public ArrayList<Double> getQuizGrades(){
        //ArrayList<Double> grades = new ArrayList<Double>();
        return this.grades;        
    }

    public ArrayList<Double> getGrades(){
        return this.grades;
    }

    public String getID() {
        return this.id.toString();
    }
    /*
    public void setNumCompletedTopics(){
        //numCompletedTopics = this.course.numCompletedTopics();
    } */
}
