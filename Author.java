import java.util.UUID;
import java.util.ArrayList;

public class Author extends Student{
/* An ArrayList of Course objects created by the author */
private ArrayList<Course> createdCourses;

/* A String representing the type of user, set to "Author" */
private String type = "Author";

/**
 * Constructor for Author class that takes in user information and initializes the createdCourses ArrayList.
 * @param firstName The first name of the user.
 * @param lastName The last name of the user.
 * @param email The email address of the user.
 * @param username The username of the user.
 * @param password The password of the user.
 */
public Author(String firstName, String lastName, String email, String username, String password){
    super(firstName, lastName, email, username, password);
    this.createdCourses = new ArrayList<>();
}

/**
 * Constructor for Author class that takes in user and course information.
 * @param id The unique ID of the user.
 * @param createdCourses An ArrayList of Course objects created by the author.
 * @param courseProgresses An ArrayList of CourseProgress objects representing the author's progress in courses.
 * @param firstName The first name of the user.
 * @param lastName The last name of the user.
 * @param email The email address of the user.
 * @param username The username of the user.
 * @param password The password of the user.
 */
public Author(UUID id, ArrayList<Course> createdCourses, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
    super(id, courseProgresses,firstName, lastName, email, username, password);
    this.createdCourses = createdCourses;
}

/**
 * Setter for the createdCourses ArrayList.
 * @param createdCourses An ArrayList of Course objects created by the author.
 */
public void setCreatedCourses(ArrayList<Course> createdCourses){
    this.createdCourses = createdCourses;
}

/**
 * Returns a String representation of the Author object.
 * @return A String representing the Author object.
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
