import java.util.ArrayList;
public class LMS {
    private User currentUser;
    private Course currentCourse;

<<<<<<< HEAD
    public User loginE(String email, String password){

        return null;

=======
    public void loginE(String email, String password, String type){
        
>>>>>>> ed2380524e137dffc2a4d739dd8b56d2e23a0eae
    }
    public User loginU(String usernam, String password){

        return null;

    }
    public void logout(){

    }
    public User signUp(String firstName, String lastName, String username, String password, String email, int type){
        
        if (type == 1) {
        Student user = new Student(firstName, lastName, email, username, password);
        return user;
        }
        //Author user = new Author(null, firstName, lastName, email, username, password);
       // return user;
       return null;
    }
    public void enrollCourse(Course course){

    }
    public void continueCourse(Course course){

    }
    public Course makeCourse(ArrayList<Topic> topics, String title, String description, double numTopics){
        Course course = new Course(topics, title, description);
        return course;
    }
    public void takeQuiz(){

    }
    public void createComment(Comment comment){

    }
    public void returnHome(){

    }
    public Topic nextTopic(){
        Topic topic = new Topic(null, null, null, null);
        return topic;
    }
    public Subtopic nextSubtopic(){
        Subtopic subtopic = new Subtopic(null, null);
        return subtopic;
    }
    public ArrayList<Course> searchCourses(String keyword){
        ArrayList<Course> courseList = new ArrayList<Course>();
        return courseList;
    }
}
