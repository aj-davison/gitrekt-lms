import java.util.UUID;
import java.util.ArrayList;
public abstract class User {
    
    protected ArrayList<CourseProgress> courseProgresses;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String email;
    protected UUID id;

    public User(String firstName, String lastName, String email, String username, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.courseProgresses = new ArrayList<CourseProgress>();
        this.id = UUID.randomUUID();
    }

    public User(UUID id, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.courseProgresses = new ArrayList<>();
    }

    public void setCourseProgress(ArrayList<CourseProgress> courseProgresses) {
        this.courseProgresses = courseProgresses;
    }

    public void addCourseProgress(CourseProgress courseProgress) {
        this.courseProgresses.add(courseProgress);
    }

    public boolean isEnrolled(Course course){
        boolean result = false;
        for(CourseProgress progress : this.courseProgresses){
            if(progress.getCourse().equals(course)){
                result = true;
            }
        }
        return result;
    }

    public ArrayList<Double> getGrades(Course course) {
        //find the course by uuid a]get return that course s grades 
        String id = course.getID();
        for(int i=0; i<courseProgresses.size(); i++){
            String IDthis = courseProgresses.get(i).getID();
            if(IDthis.equalsIgnoreCase(id)){
                return courseProgresses.get(i).getGrades();
            }
        }
        return null;
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
        if(this.courseProgresses == null){
            courseProgresses = new ArrayList<CourseProgress>();
            return result;
        }
        
        result += "Name: "+this.firstName+" "+this.lastName+"\n";
        result += "Username: "+this.username+"\n"; 
        result += "Password: "+this.password+"\n";      
        result += "Email: "+this.email+"\n";
        result += "Courses: ";
        for (CourseProgress courseProgress : courseProgresses){
            result += courseProgress.toString()+", ";
        }
        result += "\n";
        return result;
    }
}
