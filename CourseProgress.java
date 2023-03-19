import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CourseProgress {
    private static CourseList courseList;
    private UUID id;
    private HashMap<String, Double> grades;
    private int numCompletedTopics;
    private double grade;

    public CourseProgress(UUID id, HashMap<String, Double> grades, int numCompletedTopics, double grade) {
        this.id = id;
        this.grades = grades;
        this.grade = grade;
        this.numCompletedTopics = numCompletedTopics;
    }
    //TODO
    public String toString() {
        return "CourseProgress";
    }

    public void calcGrade() {
        Course course = courseList.getCourseByUUID(id);
        this.grade = course.grades();
    }
}
