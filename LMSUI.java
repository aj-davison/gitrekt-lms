import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class LMSUI {

    private static final String WELCOME_MESSAGE = "Welcome to our Coding LMS :)";
    private String[] loginMenu = {"Login with Username", "Login with Email", "Create Account", "Quit"};
    private String[] userTypeMenu = {"Student", "Author"};
    private String[] homeMenu = {"Display Current Courses","Search Courses", "Display All Courses", "Create Course", "View Profile", "Billing Page", "Log Out"};
    private String[] courseMenu = {"Enter Course", "Exit to Home"};
    private String[] topicMenu = {"Next", "Previous", "Display Comments", "Exit to Home"};
    private String[] commentMenu = {"Comment", "Comment on a Comment", "Next Topic", "Exit to Home"};
    private String[] basicMenu = {"Exit to Home"};
    private String[] quizMenu = {"Next Topic", "Exit to Home"};
    private String[] profileMenu = {"Exit to Home"};
    private Scanner scanner;
    private LMS lms;

    LMSUI() {
        scanner = new Scanner(System.in);
        lms = new LMS();
    }

    public void run() {
        System.out.println(WELCOME_MESSAGE);

        while(true) {
            
            displayMenu(loginMenu, "LOG IN OPTIONS");

            int userCommand;
			
			if ((userCommand = menuCommandValidation(homeMenu)) == -1) continue;

            User user = null;
            
            //have switch return an user
            //if it does, continue to next while loop
            //if it doesn't keep them in login while loop
            
            boolean quit = false;

            switch(userCommand) {
                case(0):
                    user = loginU();
                    break;
                case(1):
                    user = loginE();
                    break;
                case(2):
                    user = createAccount();
                    break;
                case(3):
                    quit = true;
                    break;
            }
            
            if (quit == true) break;
            
            if (user == null) {
                System.out.println("Invalid Information");
                continue;
            }

            boolean logout = false;

            while (true) {
                displayMenu(homeMenu, "HOME PAGE OPTIONS");

                if ((userCommand = menuCommandValidation(homeMenu)) == -1) continue;

                switch (userCommand) {
                    case(0):
                        displayCurrentCourses();
                        break;
                    case(1):
                        searchCourses();
                        break;
                    case(2):
                        displayAllCourses();
                        break;
                    case(3):
                        createCourse();
                    case(4):
                        viewProfile(user);
                        break;
                    case(5):
                        viewBilling();
                        break;
                    case(6):
                        logout = true;
                        logOut();
                        break;
                }
                if (logout = true) break;
            }
        }
        System.out.println("Goodbye, have a good day.");
    }

    private void displayMenu(String[] menu, String pageName) {
        System.out.println("\n****** " + pageName + " ******");
        for (int i=0; i < menu.length; i++) {
            System.out.println((i+1) + ". " + menu[i]);
        }
        System.out.println("\n");
    }

    private int getUserCommand(int numCommands) {
		
        while (true) {
            System.out.print("What would you like to do?: ");
            
            String input = scanner.nextLine();
            try {
                int command = Integer.parseInt(input) - 1;
                if(command >= 0 && command <= numCommands -1)
                    return command;
            }
            catch (Exception e) {
                System.out.println("Please enter an integer");
                continue;
            }
            return -1;
        }

	}

    private int getUserInt(String prompt) {

        while (true) {
            System.out.print(prompt);

            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= 0) 
                    return number;
            }
            catch (Exception e) {
                System.out.println("Please enter an integer");
                continue;
            }
            return -1;
        }

    }

    private int menuCommandValidation (String[] menu) {
        
        int userCommand = getUserCommand(menu.length);
        
        if(userCommand == -1) {
            System.out.println("Not a valid command");
        }
        return userCommand;
    }

    private User loginU() {

        System.out.println("\n-----Loging in-----");        

        String username = getUserString("Username");
        String password = getUserString("Password");

        return lms.loginU(username, password);

    }

    private User loginE() {

        System.out.println("\n-----Loging in-----");        

        String email = getUserString("Email");
        String password = getUserString("Password");

        return lms.loginE(email, password);

    }

    private User createAccount() {
        System.out.println("\n-----Signing Up-----");        

        String firstName = getUserString("First Name");
        String lastName = getUserString("Last Name");
        String email = getUserString("Email");
        String username = getUserString("Username");
        String password = getUserString("Password");
       
        displayMenu(userTypeMenu, "ACCOUNT OPTIONS");

        int type = getUserCommand(2);
        
        return lms.signUp(firstName, lastName, username, password, email, type);

    }

    private String getUserString(String category) {
        
        while(true) {
            System.out.print("Enter " + category + ": ");
			String info = scanner.nextLine().trim();
		
			if(!info.contentEquals("")) return info;
			
			System.out.println("You need to actually enter content");
			System.out.print("Would you like to enter item again (y) or return to main menu (n): ");
			String command = scanner.nextLine().trim().toLowerCase();
			if(command == "n"){ 
                return null;
            }
		}

    }

    private void displayCurrentCourses() {
        
    }

    private void searchCourses() {
        
    }

    private void displayAllCourses() {
        
        System.out.println("\n-----Displaying All Courses-----");
        

    }

    private Course createCourse() {
        
        System.out.println("\n-----Creating Course-----");

        String courseName = getUserString("Course Name");

        String courseDescription = getUserString("Course Description");

        String courseDifficulty = getUserString("Course Difficulty");

        int topicNum = getUserInt("How many topics will this course have?");

        ArrayList topics = new ArrayList<Topic>();
        

        for (int i = 0; i < topicNum; i++) {

            String topicName = getUserString("Topic Name #" + (i + 1));

            int subtopicNum = getUserInt("How many subtopics will this topic have?");

            ArrayList subtopics = new ArrayList<Subtopic>();

            for (int j = 0; j < subtopicNum; j++) {

                String subtopicName = getUserString("Subtopic Name #" + (i + 1));
                String subtopicInfo = getUserString("Subtopic Information: ");

                Subtopic subtopic = new Subtopic(subtopicName, subtopicInfo);

                subtopics.add(subtopic);

            }

            int questionNum = getUserInt("How many questions will the quiz for this topic have?");

            ArrayList questions = new ArrayList<Question>();

            for (int k = 0; k < topicNum; k++) {

                String questionContent = getUserString("Question # " + (k + 1));
    
                String answers[] = new String[4];
    
                for (int l = 0; l < 4; l++) {
    
                    String answerContent = getUserString("Answer #" + (l + 1));
    
                    answers[l] = answerContent;
    
                }

                int correctAnswer = getUserInt("Which Answer Number is Correct: ") - 1;

                Question question = new Question(questionContent, answers, correctAnswer);
                questions.add(question);

            }

            Quiz quiz = new Quiz(questions);

            Topic topic = new Topic(subtopics, topicName, quiz);
            topics.add(topic);

        }

        Course course = lms.makeCourse(topics, courseName, courseDescription, courseDifficulty);

        return course;

    }

    private int viewProfile(User user) {
        
        System.out.println("\n-----Profile-----");
        System.out.println(user.toString());

        while (true) {
            
            displayMenu(profileMenu, "PROFILE OPTIONS");
            
            int userCommand;

            if ((userCommand = menuCommandValidation(homeMenu)) == -1) continue;

            return userCommand;
        }
    }

    private void viewBilling() {
        
    }

    private void logOut() {
        System.out.println("See ya!");
    }

    public static void main(String[] args) {
        LMSUI lmsInterface = new LMSUI();
        lmsInterface.run();
    
    }

}
