import java.util.ArrayList;
public class LMS {
    private User currentUser;
    private Course currentCourse;

    public User loginE(String email, String password){

        return null;
    }

    public void loginE(String email, String password, String type){
        
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
        } else if(type == 2){
            Author user = new Author(firstName, lastName, email, username, password);
            return user;
        } else {
            System.out.println("Error, invalid input");
            return null;
        }
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
