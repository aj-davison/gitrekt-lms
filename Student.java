import java.util.UUID;

import javax.lang.model.util.ElementScanner14;

import java.util.ArrayList;

public class Student extends User{
    
    public Student(String firstName, String lastName, String email, String username, String password){
        super(firstName, lastName, email, username, password);
    }
    public Student(UUID id, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
        super(id, courseProgresses, firstName, lastName, email, username, password);
    }
    public void enrollCourse(Course course){  
        CourseProgress courseProgress = new CourseProgress(id, null);
        this.addCourseProgress(courseProgress);
    }
    public void unregisterCourse(Course course){
        courseProgresses.remove(course);
    }
    
}
