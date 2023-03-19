import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList(){
        //courseList = DataLoader.getCourses();
    }
    public static CourseList getInstanceCourseList(){
        if(courseList == null){
            //createnew cousre list
            courseList = new CourseList();
        }
        return courseList;
    }

    public void addCourse(ArrayList<Topic> topics, String title, String description, double numTopics){

    }

    public Course getCourse(String keyword){
        Course course = new Course(null, null, null, keyword, keyword, null, null);
        return course;
    }

    public ArrayList<Course> getCourses(){
        return courses;
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
