import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)parser.parse(reader);

            for(int i=0;i<usersJSON.size();i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get(USER_ID));
                String type = (String)userJSON.get(USER_TYPE);
                String firstName = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                String username = (String)userJSON.get(USER_USER_NAME);
                String password = (String)userJSON.get(USER_PASSWORD);
                String email = (String)userJSON.get(USER_EMAIL);

                if(type.equals("student")) {
                    users.add(new Student(id, null, firstName, lastName, email, username, password, 0, null));
                } else {
                    users.add(new Author(id, null, usersJSON, firstName, lastName, username, password, email, i, usersJSON));
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Course> getCourse() {
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Topic> topics = new ArrayList<>();
        ArrayList<Subtopic> subtopics = new ArrayList<>();
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Comment> comments = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray coursesArray = (JSONArray)parser.parse(reader);

            for(int i=0;i<coursesArray.size();i++) {
                JSONObject courseJSON = (JSONObject)coursesArray.get(i);
                UUID id = UUID.fromString((String)courseJSON.get(COURSE_ID));
                String title = (String)courseJSON.get(COURSE_TITLE);
                String description = (String)courseJSON.get(COURSE_DESCRIPTION);
                UUID authorID = UUID.fromString((String)courseJSON.get(COURSE_AUTHOR_ID));
                JSONArray studentsArray = (JSONArray)courseJSON.get(COURSE_STUDENTS_ARRAY);
                for(int j=0;j<studentsArray.size();j++) {
                    JSONObject studentJSON = (JSONObject)studentsArray.get(j);
                    UUID studentID = UUID.fromString((String)studentJSON.get(COURSE_STUDENTS_ID));
                    int completedTopics = (Integer)studentJSON.get(COURSE_STUDENT_GRADES);
                    JSONArray gradesArray = (JSONArray)studentJSON.get(COURSE_STUDENT_GRADES);
                    for(int k=0;k<gradesArray.size();k++) {
                        //TODO grades
                    }
                    // set students grades
                }
                String difficulty = (String)courseJSON.get(COURSE_DIFFICULTY);
                JSONArray topicsArray = (JSONArray)courseJSON.get(COURSE_TOPICS);
                for(int j=0;j<topicsArray.size();j++) {
                    JSONObject topicJSON = (JSONObject)topicsArray.get(j);
                    String topicTitle = (String)topicJSON.get(COURSE_TOPIC_TITLE);
                    JSONArray subtopicsArray = (JSONArray)topicJSON.get(COURSE_TOPIC_SUBTOPICS);
                    for(int k=0;k<subtopicsArray.size();k++) {
                        JSONObject subtopicJSON = (JSONObject)subtopicsArray.get(k);
                        String subtopicTitle = (String)subtopicJSON.get(COURSE_TOPIC_SUBTOPICS_TITLE);
                        String info = (String)subtopicJSON.get(COURSE_TOPIC_SUBTOPICS_INFO);
                        subtopics.add(new Subtopic(subtopicTitle, info));
                    }
                    JSONArray quizArray = (JSONArray)topicJSON.get(COURSE_TOPIC_QUIZ);
                    for(int k=0;k<quizArray.size();k++) {
                        JSONObject quizJSON = (JSONObject)quizArray.get(k);
                        String question = (String)quizJSON.get(COURSE_TOPIC_QUIZ_QUESTION);
                        JSONArray answersArray = (JSONArray)quizJSON.get(COURSE_TOPIC_QUIZ_ANSWERS);
                        String[] answers = new String[3];
                        for(int y=0;y<answersArray.size();y++) {
                            String answer = (String)answersArray.get(y);
                            answers[y] = answer;
                        }
                        int correct = (Integer)quizJSON.get(COURSE_TOPIC_QUIZ_CORRECT);
                        questions.add(new Question(question, answers, correct));
                    }
                    JSONArray commentsArray = (JSONArray)topicJSON.get(COURSE_TOPIC_COMMENTS);
                    for(int k=0;k<commentsArray.size();k++) {
                        JSONObject commentJSON = (JSONObject)commentsArray.get(k);
                        String commentContent = (String)commentJSON.get(COURSE_TOPIC_COMMENTS_CONTENT);
                        UUID creatorID = UUID.fromString((String)commentJSON.get(COURSE_TOPIC_COMMENTS_CREATOR_ID));
                        JSONArray repliesArray = (JSONArray)commentJSON.get(COURSE_TOPIC_COMMENTS_REPLIES);
                        ArrayList<Comment> replies = new ArrayList<>();
                        for(int y=0;y<repliesArray.size();y++) {
                            replies.add.getReplies((Comment)commentJSON.get(y));
                        }
                        comments.add(new Comment(creatorID, commentContent, "", replies));
                    }
                    topics.add(new Topic(subtopics, topicTitle, , new Quiz(questions)));
                }
                courses.add(new Course(id, topics, title, description, authorID));
            }
            reader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static ArrayList<Comment> getReplies(Comment comment) {
        ArrayList<Comment> replies = new ArrayList<>();
        for(int i=0;i<replies.size();i++) {
            replies.add(getReplies(replies.get(i)));
        }
        return replies;
    }

    public static void main(String[] args) {
        /*ArrayList<User> test = getUsers();
        for(int i=0;i<test.size();i++) {
            System.out.print(test.get(i).getUsername());
            System.out.println();
        }*/

        UserList list = UserList.getInstanceUserList();
        ArrayList<User> users = list.getUsers();

        

        for(User user : users){
            System.out.println(user.getUsername());
        }
    }
}
