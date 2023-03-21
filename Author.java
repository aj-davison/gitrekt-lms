import java.util.UUID;
import java.util.ArrayList;

public class Author extends Student{
    private ArrayList<Course> createdCourses;

    public Author(String firstName, String lastName, String email, String username, String password){
        super(firstName, lastName, email, username, password);
        this.createdCourses = new ArrayList<>();
    }
    public Author(UUID id, ArrayList<Course> createdCourses, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
        super(id, courseProgresses,firstName, lastName, email, username, password);
        this.createdCourses = createdCourses;
    }
   // public Course createCourse(){
       // Course course = new Course(null, getEmail(), getEmail());
       // return course;
   // }
   public void setCreatedCourses(ArrayList<Course> createdCourses){
        this.createdCourses = createdCourses;
   }
    
}
