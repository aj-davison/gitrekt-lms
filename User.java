import java.util.UUID;
import java.util.ArrayList;
public abstract class User {
    
    private ArrayList<CourseProgress> courseProgresses;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private UUID id;

    public User(ArrayList<CourseProgress> courseProgresses,String firstName, String lastName, String username, String password, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.courseProgresses = courseProgresses;
    }

    public User(UUID id, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.courseProgresses = courseProgresses;
    }

    public void addCourseProgress(CourseProgress courseProgress) {
        courseProgresses.add(courseProgress);
    }

    public String getUsername() {
        if(username == null)
            return null;
        else
            return this.username;
    }

    public String getID() {
        if(id == null)
            return null;
        else
            return this.id.toString();
    }

    public String getFirstName() {
        if(firstName == null)
            return null;
        else
            return this.firstName;
    }

    public String getLastName() {
        if(lastName == null)
            return null;
        else
            return this.lastName;
    }

    public String getPassword() {
        if(password == null)
            return null;
        else
            return this.password;
    }

    public String getEmail() {
        if(email == null)
            return null;
        else
        return this.email;
    }
    public String toString(){
        String result = "";
        result += "Name: "+this.firstName+" "+this.lastName+"\n";
        result += "Username: "+this.username+"\n";       
        result += "Email: "+this.email+"\n";
        result += "Courses: ";
        for (CourseProgress i : courseProgresses){
            result += i+", ";
        }
        result += "\n";
        return result;
    }
}
