import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    /**
    Constructs a new CourseList object by loading the courses from the data source.
    */
    private CourseList(){
        courses = DataLoader.getCourses();
    }

    /**
    Returns the singleton instance of the CourseList.
    If no instance exists, creates a new instance and returns it.
    @return the singleton instance of the CourseList
    */
    public static CourseList getInstanceCourseList(){
        if(courseList == null){
            //createnew cousre list
            courseList = new CourseList();
        }
        return courseList;
    }

    /**
    Adds a new course to the course list with the given parameters.
    @param topics - the list of topics for the course
    @param title - the title of the course
    @param description - the description of the course
    @param difficulty - the difficulty level of the course
    @param authorID - the ID of the author of the course
    */
    public void addCourse(ArrayList<Topic> topics, String title, String description, Difficulty difficulty, UUID authorID){
        courses.add(new Course(title, description, difficulty, authorID));
    }

    /**
    Returns the course with the given UUID.
    @param uuid - the UUID of the course to be retrieved
    @return the course with the given UUID, or null if no course with that UUID exists in the list.
    */
    public Course getCourseByUUID(UUID uuid){
        for(int i=0; i<courses.size(); i++){
            if(courses.get(i).getID().equalsIgnoreCase(uuid.toString())){
                return courses.get(i);
            }
        }
        return null;
    }
    public Course getCourseByTitle(String title){
        for(int i=0; i<courses.size(); i++){
            if(courses.get(i).getTitle().equalsIgnoreCase(title)){
                return courses.get(i);
            }
        }
        return null;
    }

    /**
    Returns the list of courses.
    @return the list of courses
    */
    public ArrayList<Course> getCourses(){
        return courses;
    }


    //TODO
    public void editCourse(/*TODO*/){

    }

    /**
    Saves the courses to the JSON.
    */
    public void saveCourses(){
        DataWriter.saveCourses();
    }
    
    /**
    Returns a list of all courses as strings.
    @return a list of all courses as strings
    */
    public ArrayList<String> getAllCourses(){
        ArrayList<String> allCourses = new ArrayList<String>();
        return allCourses;
    }
    public void enrollCourse(String title, User user){
        Course course = getCourseByTitle(title);
        CourseProgress courseProgress = new CourseProgress(course);
        user.courseProgresses.add(courseProgress);
    }
    public ArrayList<Course> searchCourses(String title){
        ArrayList<Course> results = new ArrayList<Course>();
        ArrayList<Course> courses = getCourses();
        title = title.toLowerCase();
        for (Course course : courses){
            String courseTitle = course.getTitle().toLowerCase();
            if(courseTitle.contains(title)){
                results.add(course);
            }
        }
        if(results.size() == 0){
            return null;
        }
        return results;
    }
    public String displayCourseList(){
        String result = "";
        int index = 1;
        for(Course course : courses){
            result += Integer.toString(index)+". "+course.getTitle()+"\n";
            index ++;
        }
        return result;
    }
}
