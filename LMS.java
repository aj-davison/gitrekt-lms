import java.util.ArrayList;
public class LMS {
    //private static UserList userList;
    private User currentUser;
    private Course currentCourse;

    public User loginE(String email, String password){
        UserList userList = UserList.getInstanceUserList();
        this.currentUser = userList.getUserByEmail(email);
        if(currentUser != null && currentUser.getPassword().equalsIgnoreCase(password)){
            return currentUser;
        }
        return null;
    }
    public User loginU(String username, String password){
        UserList userList = UserList.getInstanceUserList();
        this.currentUser = userList.getUserByUsername(username);
        if(currentUser != null && currentUser.getPassword().equalsIgnoreCase(password)){
            return currentUser;
        }
        return null;
    }
    public void logout(){

    }
    public User signUp(String firstName, String lastName, String username, String password, String email, int type){
        
        if (type == 1) {
            Student user = new Student(firstName, lastName, email, username, password);
            userList.addStudent(firstName, lastName, email, username, password);
            return user;
        } else if(type == 2){
            Author user = new Author(firstName, lastName, email, username, password);
            userList.addAuthor(firstName, lastName, email, username, password);
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
