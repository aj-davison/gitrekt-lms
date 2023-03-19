import java.util.HashMap;

public class CourseProgress {
    
    private Course course;
    private HashMap<Quiz, Double> quizzes;
    private int numCompletedTopics;

    public CourseProgress(Course course, HashMap<Quiz, Double> quizzes, int numCompletedTopics) {
        this.course = course;
        this.quizzes = quizzes;
        this.numCompletedTopics = numCompletedTopics;
    }
    //TODO
    public String toString() {
        return "CourseProgress";
    }

    public double calcGrade() {
        int questions = this.course.numCompletedTopics()*3;
        return this.course.score()/questions;
    }
}
