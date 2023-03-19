import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList(){
        courses = DataLoader.getCourses();
    }
    public static CourseList getInstanceCourseList(){
        if(courseList == null){
            //createnew cousre list
            courseList = new CourseList();
        }
        return courseList;
    }

    public void addCourse(ArrayList<Topic> topics, String title, String description, Difficulty difficulty, UUID authorID){
        courses.add(new Course(title, description, difficulty, authorID));
    }

    public Course getCourseByUUID(UUID uuid){
        for(int i=0; i<courses.size(); i++){
            if(courses.get(i).getID().equalsIgnoreCase(uuid.toString())){
                return courses.get(i);
            }
        }
        return null;
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }
    //TODO
    public void editCourse(/*TODO*/){

    }


    public void saveCourses(){

    }
    public ArrayList<String> getAllCourses(){
        ArrayList<String> allCourses = new ArrayList<String>();
        return allCourses;
    }
}
