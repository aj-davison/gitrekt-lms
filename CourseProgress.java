import java.util.ArrayList;
import java.util.UUID;

public class CourseProgress {
    private UUID id;
    private ArrayList<Double> grades;

    public CourseProgress(UUID id, ArrayList<Double> grades) {
        this.id = id;
        this.grades = grades;
    }
    //TODO
    public String toString() {
        return "CourseProgress";
    }
    public void addGrade(double grade){
        this.grades.add(grade);
    }
    public Double getGrade(){
        int questions = this.grades.size();
        double grade = 0;
        for(double score : grades) {
            grade += score;
        }
        grade /= questions;
        return grade;
    }
    public ArrayList<Double> getGrades(){
        return this.grades;
    }
    public String getID() {
        return this.id.toString();
    }
    public int numCompletedTopics(){
        return this.grades.size();
    } 
}
