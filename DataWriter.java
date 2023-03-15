import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

	public static void saveCourses() {
		CourseList courselist = CourseList.getInstanceCourseList(); 
		ArrayList<Course> courses = courselist.getCourses();
		JSONArray jsonCourses = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i < courses.size(); i++) {
			jsonCourses.add(getCourseJSON(courses.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
 
            file.write(jsonCourses.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getCourseJSON(Course course) {
		JSONObject courseDetails = new JSONObject();
        courseDetails.put(COURSE_ID, course.getID());
		courseDetails.put(COURSE_TITLE, course.getTitle());
		courseDetails.put(COURSE_DESCRIPTION, course.getDescription());
		
        
        return courseDetails;
	}
	
    //-------------------------------------------


	public static void saveUsers() {
		UserList userlist = UserList.getInstanceUserList(); 
		ArrayList<User> users = userlist.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i < users.size(); i++) {
			jsonUsers.add(getUserJSON(users.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getID());
        //here we check if they are student of aouther type
        if(user instanceof Student)
            userDetails.put(user, "student");
        else // they are an author
            userDetails.put(user, "author");
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_USER_NAME, user.getUsername());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_EMAIL,user.getEmail());
        
        return userDetails;
	}

}