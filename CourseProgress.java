import java.util.HashMap;

public class CourseProgress {
    
    private Course course;
    private HashMap<Quiz, Double> quizzes;
    private int numCompletedTopics;
    private double grade;

    public CourseProgress(Course course, HashMap<Quiz, Double> quizzes, int numCompletedTopics, double grade) {
        this.course = course;
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
