import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

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
        courseDetails.put(COURSE_AUTHOR_ID, course.getAuthorIDstring());
        courseDetails.put(COURSE_STUDENTS_ARRAY ,getStudentsJSON(course));
        courseDetails.put(COURSE_DIFFICULTY, course.getDifficulty());
        courseDetails.put(COURSE_TOPICS ,getTopicsJSON(course));
		
        
        return courseDetails;
	}

    private static JSONArray getTopicsJSON(Course course) {
        JSONArray jsonTopics = new JSONArray();
        ArrayList<Topic> topics = course.getTopics();
        for(int i=0; i<topics.size(); i++){
            jsonTopics.add(getTopicJSON(topics.get(i)));
        }
        return jsonTopics;
    }






    

    private static JSONObject getTopicJSON(Topic topic) {
        JSONObject topicsDetails = new JSONObject();
        topicsDetails.put(COURSE_TOPIC_TITLE, topic.getName());
        topicsDetails.put(COURSE_TOPIC_SUBTOPICS, getTopicSubTopicsJSON(topic));
        topicsDetails.put(COURSE_TOPIC_QUIZ, getTopicQuizJSON(topic));
        topicsDetails.put(COURSE_TOPIC_COMMENTS, getTopicComments(topic));
        return topicsDetails;
    }

    private static JSONArray getTopicComments(Topic topic) {
        JSONArray jsonComments = new JSONArray();
        ArrayList<Comment> comments =  topic.getComments();
        for(int i=0; i<comments.size(); i++){
            jsonComments.add(commentJSON(comments.get(i)));
        }
        return jsonComments;
    }

    private static JSONObject commentJSON(Comment comment) {
        JSONObject commentDetail = new JSONObject();
        commentDetail.put(COURSE_TOPIC_COMMENTS_CONTENT, comment.getContent());
        commentDetail.put(COURSE_TOPIC_COMMENTS_CREATOR_ID, comment.getID().toString());
        JSONArray jsonReplies = new JSONArray();
        for(int i=0; 0<comment.getReplies().size(); i++){
            //jsonReplies.add(comment.getReplies().get(i));
            jsonReplies.add(commentJSON(comment.getReplies().get(i)));
        }
        commentDetail.put(COURSE_TOPIC_COMMENTS_REPLIES, jsonReplies);

        return commentDetail;
    }

    private static JSONArray getTopicQuizJSON(Topic topic) {
        JSONArray jsonQuiz = new JSONArray();
        ArrayList<Question> quiz=  topic.getQuiz().getQuestions();
        for(int i=0; i<quiz.size(); i++){
            jsonQuiz.add(questionJSON(quiz.get(i)));
        }
        return jsonQuiz;
    }

    private static JSONObject questionJSON(Question question) {
        JSONObject questionDetail = new JSONObject();
        questionDetail.put(COURSE_TOPIC_QUIZ_QUESTION, question.getQuestion());
        questionDetail.put(COURSE_TOPIC_QUIZ_CORRECT, question.getCorrect());
        JSONArray jsonAns = new JSONArray();
        for(int i=0; 0<question.getAns().length; i++){
            jsonAns.add(question.getAns()[i]);
        }
        questionDetail.put(COURSE_TOPIC_QUIZ_ANSWERS, jsonAns);



        return questionDetail;
    }

    private static JSONArray getTopicSubTopicsJSON(Topic topic) {
        JSONArray jsonSubTop = new JSONArray();
        ArrayList<Subtopic> subTops =  topic.getSubTop();
        for(int i=0; i<subTops.size(); i++){
            jsonSubTop.add(subTopInfoJSON(subTops.get(i)));
        }
        return jsonSubTop;
    }

    private static JSONObject subTopInfoJSON(Subtopic subTop){
        JSONObject subTopDetail = new JSONObject();
        subTopDetail.put(COURSE_TOPIC_SUBTOPICS_TITLE, subTop.getName());
        subTopDetail.put(COURSE_TOPIC_SUBTOPICS_INFO, subTop.getInfo());
        return subTopDetail;
    }




    private static JSONArray getStudentsJSON(Course course) {
        JSONArray jsonStudents = new JSONArray();
        ArrayList<Student> students = course.getStudents();
        for(int i=0; i < students.size(); i++){
            jsonStudents.add(getStudentJSON(students.get(i)));
        }
        return jsonStudents;
    }

    private static JSONObject getStudentJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put(COURSE_STUDENTS_ID, student.getID());
        studentDetails.put(COURSE_STUDENT_COMP_TOPICS, student.getTopicsCompleted());
        studentDetails.put(COURSE_STUDENT_GRADES, getGradesJSON(student));

        return studentDetails;
    }

    private static JSONArray getGradesJSON(Student student) {
        JSONArray jsonGradess = new JSONArray();
        ArrayList<Double> grades = student.getGrades();
        for(int i=0; i<grades.size(); i++){
            jsonGradess.add(grades.get(i));
        }
        return jsonGradess;
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
            userDetails.put(USER_TYPE, "student");
        else // they are an author
            userDetails.put(USER_TYPE, "author");
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_USER_NAME, user.getUsername());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_EMAIL,user.getEmail());
        
        return userDetails;
	}

    public static void main(String[] args){
        UserList userList = UserList.getInstanceUserList();
        //ArrayList<User> users =userList.getUsers();
        //users.add(new Student(UUID.randomUUID(),null, "Portia","Plante", "pplante","sdfew","sdfsw@sdfe.com"));
        saveUsers();
        //saveCourses();
    }

}