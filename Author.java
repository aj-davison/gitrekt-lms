import java.util.UUID;
import java.util.ArrayList;

public class Author extends Student{
    private ArrayList<Course> createdCourses;

    public Author(int topicsCompleted, ArrayList<Double> grades, ArrayList<Course> createdCourses, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
        super(courseProgresses, firstName, lastName, email, username, password);
        this.createdCourses = new ArrayList<>();
    }
    public Author(UUID id, ArrayList<Course> createdCourses, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password, int topicsCompleted, ArrayList<Double> grades){
        super(id, courseProgresses,firstName, lastName, email, username, password, topicsCompleted, grades);
        this.createdCourses = createdCourses;
    }
   // public Course createCourse(){
       // Course course = new Course(null, getEmail(), getEmail());
       // return course;
   // }
    
}
