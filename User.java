import java.util.UUID;

public abstract class User {
    
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private UUID id;

    public User(String firstName, String lastName, String username, String password, String email) {

    }

    public User(UUID id, String firstName, String lastName, String username, String password, String email) {

    }

    public void addCourseProgress(CourseProgress courseProgress) {

    }

    public String getUsername() {
        return "";
    }
}
