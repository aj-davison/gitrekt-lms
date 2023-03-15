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

    }

    public User(UUID id, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String username, String password, String email) {

    }

    public void addCourseProgress(CourseProgress courseProgress) {

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
}
