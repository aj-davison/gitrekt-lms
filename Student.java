import java.util.UUID;

import javax.lang.model.util.ElementScanner14;

import java.util.ArrayList;

/**
 * A student class
 */
public class Student extends User{

    private String type = "Student";
    
    /**
     * Creates a new instance of Student
     * @param firstName A string of the users first name
     * @param lastName A string of the users last name
     * @param email A string of the users email
     * @param username A string of the users username
     * @param password A string of the users password
     */
    public Student(String firstName, String lastName, String email, String username, String password){
        super(firstName, lastName, email, username, password);
    }

    /**
     * Creates a new instance of Student
     * @param id A string of the users id
     * @param courseProgresses An ArrayList of courseprogresses
     * @param firstName A string of the users first name
     * @param lastName A string of the users last name
     * @param email A string of the users email
     * @param username A string of the users username
     * @param password A string of the users password
     */
    public Student(UUID id, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
        super(id, courseProgresses, firstName, lastName, email, username, password);
    }


    public void makeCourse(ArrayList<Topic> topics, String title, String description, int difficulty){
        
    }
/* 
    public void unregisterCourse(Course course){
        courseProgresses.remove(course);
    }
*/  

    public ArrayList<Course> getCreatedCourses(){
        return null;
    }

    public String displayCreatedCourses(){
        return "Sorry, you are a student";
    }

    /**
     * Makes the student a string
     * @return returns a string representation of the student
     */
    public String toString(){
        String result = "";
        if(this.courseProgresses == null){
            courseProgresses = new ArrayList<CourseProgress>();
            return result;
        }
        
        result += "Name: "+this.firstName+" "+this.lastName+"\n";
        result += "Username: "+this.username+"\n";       
        result += "Password: "+this.password+"\n";
        result += "Email: "+this.email+"\n";
        result += "Type: "+this.type+"\n";
        result += "Courses: ";
        for (CourseProgress courseProgress : courseProgresses){
            result += courseProgress.toString()+", ";
        }
        result += "\n";
        return result;
    }
}