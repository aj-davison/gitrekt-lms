import java.util.UUID;
import java.util.ArrayList;

public class Author extends Student{
    private ArrayList<Course> createdCourses;

    public Author(ArrayList<Course> createdCourses,ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
        super(courseProgresses, firstName, lastName, email, username, password);
    }
    public Author(UUID id, ArrayList<Course> createdCourses,ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
        super(courseProgresses, firstName, lastName, email, username, password);
    }
    public Course createCourse(){
        Course course = new Course(null, getUsername(), getUsername());
        return course;
    }
}
