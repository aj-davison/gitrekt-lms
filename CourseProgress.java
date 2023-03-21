import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CourseProgress {
    private static CourseList courseList;
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
<<<<<<< HEAD
        Course course = courseList.getCourseByUUID(id);
        this.grade = course.grades();
=======
        int questions = this.grades.size();
        for(double score : grades) {
            this.grade += score;
        }
        this.grade /= questions;
>>>>>>> ff277227ddb382bec05543feaf3b9a279485292e
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
