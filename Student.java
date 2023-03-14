import java.util.ArrayList;

public class Student extends User{
    public Student(ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
        super(courseProgresses, firstName, lastName, email, username, password);
    }
    public void enrollCourse(Course course){

    }
    public void continueCourse(Course course){

    }
    public void unregisterCourse(Course course){
        
    }
}
