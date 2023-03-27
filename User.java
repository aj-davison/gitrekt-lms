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
    public CourseProgress getCourseProgress(String title){
        for(CourseProgress course : this.courseProgresses){
            if(course.getCourse().getTitle().equalsIgnoreCase(title)){
                return course;
            }
        }
        return null;
    }
    public ArrayList<Double> getCourseGrades(Course course) {
        for(int i=0; i<courseProgresses.size(); i++){
            if(courseProgresses.get(i).getCourse().equals(course)){
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
    public void enrollCourse(Course course){  
        CourseProgress courseProgress = new CourseProgress(course, null);
        this.addCourseProgress(courseProgress);
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
    public String getCurrentCourses(){
        String result = "";
        int position = 1;
        for(CourseProgress course : courseProgresses){
            result += Integer.toString(position)+". "+course.getCourse().getTitle()+"\n";
            position++;
        }
        return result;
    }
}


