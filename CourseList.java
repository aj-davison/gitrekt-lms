import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> courses;
    private CourseList(){

    }
    public CourseList getInstanceCourseList(){
        return this;
    }
    public void addCourse(ArrayList<Topic> topics, String title, String description, double numTopics){

    }
    public Course getCourse(String keyword){
        Course course = new Course(null, keyword, keyword);
        return course;
    }
    public void editCourse(/*TODO*/){

    }
    public void saveCourses(){

    }
    public ArrayList<String> getAllCourses(){
        ArrayList<String> allCourses = new ArrayList<String>();
        return allCourses;
    }
}
