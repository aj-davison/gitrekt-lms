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
        this.courseProgresses = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    public User(UUID id, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        setCourseProgress(courseProgresses);
    }

    public void addCourseProgress(Course course) {
        this.courseProgresses.add(new CourseProgress(course));
    }

    public void setCourseProgress(ArrayList<CourseProgress> courseProgresses) {
        if(courseProgresses == null) {
            this.courseProgresses = new ArrayList<>();
        }
        this.courseProgresses = courseProgresses;
    }

    public ArrayList<Double> getGrades(Course course) {
        //find the course by uuid a]get return that course s grades 
        String id = course.getID();
        for(int i=0; i<courseProgresses.size(); i++){
            ArrayList<Student> students = courseProgresses.get(i).getCourse().getStudents();
            for(int j=0;j<students.size();j++) {
                String IDthis = students.get(j).getID();
                if(IDthis.equalsIgnoreCase(id)){
                    return courseProgresses.get(i).getGrades();
                }
            }
        }
        return null;
    }

    public ArrayList<CourseProgress> getCourseProgresses() {
        return this.courseProgresses;
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
        this.addCourseProgress(course);
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
    
    public ArrayList<Course> getCurrentCourses() {

        ArrayList<Course> currentCourses = new ArrayList<Course>();
        for (CourseProgress courseProgress : courseProgresses) {
            
            currentCourses.add(courseProgress.getCourse());

        }

        return currentCourses;

    }
    public boolean courseComplete(Course course){
        boolean result = false;
        int position = 0;
        for(CourseProgress progress : this.courseProgresses){
            if(progress.getCourse().equals(course)){
                break;
            }
            position++;
        }
        if(this.courseProgresses.get(position).getGrades().size() == course.getTopics().size()){
            result = true;
        }
        return result;
    }

    public Double calcGrade(Course course){
        double result = 0.0;
        for(CourseProgress progress : this.courseProgresses){
            if(progress.getCourse().equals(course)){
                result = progress.getGrade();
            }
        }
        return result;
    }
    public void updateGrades(Course course, double grade){
        for(CourseProgress progress : this.courseProgresses){
            if(progress.getCourse().equals(course)){
                progress.addGrade(grade);
            }
        }
    }
    
    public String currentCoursesToString(){
        String result = "";
        int position = 1;
        for(CourseProgress course : courseProgresses){
            result += Integer.toString(position)+". "+course.getCourse().getTitle()+"\n";
            position++;
        }
        return result;
    }
}


