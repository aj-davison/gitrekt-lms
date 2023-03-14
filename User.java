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
        return "";
    }
}
