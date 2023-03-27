import java.util.ArrayList;
public class LMS {
    private static UserList userList = UserList.getInstanceUserList();
    private static CourseList courseList = CourseList.getInstanceCourseList();
    private User currentUser;
    private Course currentCourse;

    public User loginE(String email, String password){
        currentUser = userList.loginE(email, password);
        return currentUser;
    }
    public User loginU(String username, String password){
        currentUser = userList.loginU(username, password);
        return currentUser;
    }
    public void logout(){
        userList.saveUsers();
        courseList.saveCourses();
    }
    public User signUp(String firstName, String lastName, String username, String password, String email, int type){
        return userList.signUp(firstName, lastName, username, password, email, type);
    }
    public void enrollCourse(String title){
        courseList.enrollCourse(title, currentUser);
    }
    public ArrayList<Course> searchCourses(String title){
        return courseList.searchCourses(title);
    }
    public Course getCourseByTitle(String title){
        return courseList.getCourseByTitle(title);
    }
    public boolean isEnrolled(Course course){
        boolean result = false;
        for(CourseProgress progress : currentUser.courseProgresses){
            if(progress.getID().equals(course.getUuid().toString())){
                result = true;
            }
        }
        return result;
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
}
