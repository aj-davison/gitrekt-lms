import java.util.ArrayList;
public class LMS {
    private static UserList userList;
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
        UserList userList = UserList.getInstanceUserList();
        userList.saveUsers();
        CourseList courseList = CourseList.getInstanceCourseList();
        courseList.saveCourses();
    }
    public User signUp(String firstName, String lastName, String username, String password, String email, int type){
        
        UserList userList = UserList.getInstanceUserList();
        if (type == 0) {
            Student user = new Student(firstName, lastName, email, username, password);
            userList.addStudent(firstName, lastName, email, username, password);
            DataWriter.saveUsers();
            return user;
        } else if(type == 1){
            Author user = new Author(firstName, lastName, email, username, password);
            userList.addAuthor(firstName, lastName, email, username, password);
            DataWriter.saveUsers();
            return user;
        } else {
            System.out.println("Error, invalid input");
            return null;
        }
    }
    public void enrollCourse(String title){
        CourseList courseList = CourseList.getInstanceCourseList();
        Course course = courseList.getCourseByTitle(title);
        CourseProgress courseProgress = new CourseProgress(course.getUuid());
        currentUser.courseProgresses.add(courseProgress);
    }
    public String displayCourseList(){
        String result = "";
        CourseList courseList = CourseList.getInstanceCourseList();
        ArrayList<Course> courses = courseList.getCourses();
        int index = 1;
        for(Course course : courses){
            result += index+". "+course.getTitle()+"\n";
            index ++;
        }
        return result;
    }
    public void continueCourse(Course course){
        int index = 0;
        for(CourseProgress progress : currentUser.courseProgresses){
            if(progress.getID().equalsIgnoreCase(course.getID())){
                break;
            }
            index++;
        }
        int topicIndex = currentUser.courseProgresses.get(index).numCompletedTopics();
        for(int i=0; i<course.getTopics().size()-topicIndex; i++){
            course.getTopics().get(index).toString();
        }
    }
    public boolean continueTopic(int input){
        boolean result;
        if(input == 1){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    public Course makeCourse(ArrayList<Topic> topics, String title, String description, String difficulty){
        
        Course course = new Course(title, description, null, topics, null);

        DataWriter.saveCourses();


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
