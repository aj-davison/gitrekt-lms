import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class LMSUI {

    private static final String WELCOME_MESSAGE = "\n\nWelcome to our Coding LMS :)";
    private String[] loginMenu = {"Login with Username", "Login with Email", "Create Account", "Quit"};
    private String[] userTypeMenu = {"Student", "Author"};
    private String[] homeMenu = {"Display Current Courses","Search Courses", "Display All Courses", "Create Course", "Edit Course", "View Profile", "Billing Page", "Log Out"};
    private String[] continueCourseMenu = {"Continue Course", "View Grades", "View Topics", "Exit to Home"};
    private String[] completedCourseMenu = {"View Grades", "Print Certificate", "View Topics","Exit to Home"};
    private String[] newCourseMenu = {"Enroll in Course", "View Topics", "Exit to Home"}; 
    private String[] courseListMenu = {"Select Course", "Exit to Home"};
    private String[] editCourseMenu = {"Add Subtopic", "Add Question", "Exit to Home"};
    private String[] createdCoursesMenu = {"Choose Course", "Exit to Home"};
    private String[] createdTopicMenu = {"Choose Topic", "Exit to Home"};
    private String[] editTopicMenu = {"Add Subtopic", "Add Question", "Exit to Home"};
    private String[] topicMenu = {"Quiz", "Display Comments", "Next Topic", "Exit to Home"};
    private String[] commentMenu = {"Comment", "View Comment Replies", "Next Topic", "Exit to Home"};
    private String[] basicMenu = {"Exit to Home"};
    private String[] quizMenu = {"Next Topic", "Display Comments", "Print out Topic", "Exit to Home"};
    private String[] profileMenu = {"Exit to Home"};
    private String[] billingMenu = {"Exit to Home"};
    private String[] subtopicMenu = {"Next", "Previous", "Quit"};
    private String[] difficultyMenu = {"Beginner", "Intermediate", "Advanced"};
    private String[] endOfSubTopsMenu = {"Previous", "Quit"};
    private String[] firstSubTopsMenu = {"Next", "Quit"};
    private String[] oneSubTopMenu = {"Continue to Quiz and Comments"}; 
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
			
			if ((userCommand = menuCommandValidation(loginMenu)) == -1) continue;

            User user = null;
            
            //have switch return an user
            //if it does, continue to next while loop
            //if it doesn't keep them in login while loop
            
            boolean quit = false;

            switch(userCommand) {
                case(0):
                    user = loginU();
                    clearScreen();
                    break;
                case(1):
                    user = loginE();
                    clearScreen();
                    break;
                case(2):
                    user = createAccount();
                    clearScreen();
                    break;
                case(3):
                    quit = true;
                    clearScreen();
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
                        clearScreen();
                        break;
                    case(1):
                        searchCourses();
                        clearScreen();
                        break;
                    case(2):
                        displayAllCourses();
                        clearScreen();
                        break;
                    case(3):
                        createCourse();
                        clearScreen();
                        break;
                    case(4):
                        editCourse();
                        clearScreen();
                        break;
                    case(5):
                        viewProfile(user);
                        clearScreen();
                        break;
                    case(6):
                        viewBilling();
                        clearScreen();
                        break;
                    case(7):
                        logout = true;
                        logOut();
                        break;
                }
                if (logout == true) break;
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
        clearScreen();
        System.out.println("\n-----Loging in-----");        

        String username = getUserString("Username");
        String password = getUserString("Password");

        return lms.loginU(username, password);

    }

    private User loginE() {
        clearScreen();
        System.out.println("\n-----Loging in-----");        

        String email = getUserString("Email");
        String password = getUserString("Password");

        return lms.loginE(email, password);

    }

    private User createAccount() {
        clearScreen();
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
		}

    }
    private void displayCurrentCourses() {
        clearScreen();
        
        boolean quit = false;
        
        System.out.println("\n-----Displaying Current Courses-----");

        ArrayList<Course> currentCourses = lms.getCurrentCourses();
        System.out.println(lms.currentCoursesToString());
        
        while (true) {
        
            displayMenu(courseListMenu, "CURRENT COURSE OPTIONS");

            int userCommand;
            if ((userCommand = menuCommandValidation(courseListMenu)) == -1) continue;

            switch(userCommand) {
                case(0):
                    while (true){
                        userCommand = getUserInt("Which course would you like to select? ") -1;
                        if (userCommand < 0 || userCommand >= currentCourses.size()) continue;
                        break;
                    }
                    String courseChoice = currentCourses.get(userCommand).getTitle();
                    Course course = lms.getCourseByTitle(courseChoice);
                    displayCourseDescription(course);
                    return;
                case(1):
                    quit = true;
                    break;
            }
            if (quit == true) return;

        }
    }

    public void continueCourse(Course course, CourseProgress courseProgress) {
        int numCompleteTopics = courseProgress.numCompletedTopics();
        int numTopics = course.getTopics().size();

        for (int i = numCompleteTopics; i < numTopics; i++) {

            Topic currentTopic = course.getTopics().get(i);
            printTopic(currentTopic);

            int userCommand;
            boolean quit = false;
            while (true) {
                
                displayMenu(topicMenu, "TOPIC OPTIONS");
                if ((userCommand = menuCommandValidation(topicMenu)) == -1) continue;
                break;
            }

            switch (userCommand) {
                case(0):
                    displayQuiz(course, currentTopic);
                    break;
                case(1):
                    displayComments(currentTopic.getComments());
                    break;
                case(2):
                    break;
                case(3):
                    return;
            }

        }
        //break;

    }


    private void displayQuiz(Course currentCourse, Topic currentTopic) {

        System.out.println("\n-----Quiz-----");
        Quiz quiz = currentTopic.getQuiz();

        for (int i = 0; i < quiz.getQuizSize(); i++) {

            Question question = quiz.getQuestionAt(i);
            System.out.println(question.toString());

            int userAnswer;

            while (true) {

                userAnswer = getUserInt("Which answer is correct? ") -1;
                if (userAnswer < 0 || userAnswer >= question.getAns().length) {
                    System.out.println("Invalid");
                    continue;
                }
                break;
            }

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct!");
                
            }
            else {

                System.out.println("Wrong!");
                System.out.println("Correct Answer: " + question.getCorrectAns());

            }

        }

        System.out.println("Your Grade: " + quiz.getGrade());
        lms.updateGrades(currentCourse, quiz.getGrade());


    }

    private void printTopic(Topic topic) {

        boolean quit = false;

        while (true) {
        
            for (int i = 0; i < topic.getSubTop().size(); i++) {

                System.out.println(topic.getSubTop().get(i).toString());
                
                
                if (topic.getSubTop().size() == 1) {
                    while (true) {
                        displayMenu(oneSubTopMenu, "SUBTOPIC OPTIONS");

                        int userCommand;

                        if ((userCommand = menuCommandValidation(oneSubTopMenu)) == -1) {
                            System.out.println("invalid");
                            continue;
                        }
                        
                        switch(userCommand) {
                            case(0):
                                quit = true;
                                System.out.print("\033[H\033[2J");  //these are my chenges to clear the consle when you go to the quiz if it works we will move it to allother metheds that need it 
                                System.out.flush();  //these are my chenges to clear the consle when you go to the quiz if it works we will move it to allother metheds that need it
                                break;
                        }
                        if (quit == true) return;
                        break;
                    }
                }
                else if (i != topic.getSubTop().size() - 1 && i != 0) {
                    while (true) {
                        displayMenu(subtopicMenu, "SUBTOPIC OPTIONS");

                        int userCommand;

                        if ((userCommand = menuCommandValidation(subtopicMenu)) == -1) continue;
                        
                        switch(userCommand) {
                            case(0):
                                break;
                            case(1):
                                i -= 2;
                                break;
                            case(2):
                                quit = true;
                                break;
                        }
                        if (quit == true) return;
                        break;
                    }
                }
                else if (topic.getSubTop().size() != 1 && i==0) {
                    while (true) {
                        displayMenu(firstSubTopsMenu, "SUBTOPIC OPTIONS");

                        int userCommand;

                        if ((userCommand = menuCommandValidation(firstSubTopsMenu)) == -1) continue;
                        
                        switch(userCommand) {
                            case(0):
                                break;
                            case(1):
                                quit = true;
                                break;
                        }
                        if (quit == true) return;
                        break;
                    }
                }
                else {
                    while (true) {
                        displayMenu(endOfSubTopsMenu, "SUBTOPIC OPTIONS");

                        int userCommand;

                        if ((userCommand = menuCommandValidation(endOfSubTopsMenu)) == -1) continue;
                        
                        switch(userCommand) {
                            case(0):
                                i -= 2;
                                break;
                            case(1):
                                quit = true;
                                break;
                        }
                        if (quit == true) return;
                        break;
                    }
                }
            }     
        } 
    }


    private void searchCourses() {
        clearScreen();
        System.out.println("\n-----Search Courses-----");
        
        ArrayList<Course> results;
        while (true) {
            String word = getUserString("Keyword or # to Exit");
            if (word.equals("#")) return;
            results = lms.searchCourses(word);
            if(results == null){
                System.out.println("No Match");
                continue;
            }
            break;
        }
        int index = 1;
        for(Course course : results){
            String result = "";
            result += Integer.toString(index)+". "+course.getTitle()+"\n";
            System.out.println(result);
            index++;
        }
        int choice = getUserInt("Enter Course Number: \n");
        displayCourseDescription(results.get(choice-1));
    }

    //sup

    private void displayCourseDescription(Course course){
        System.out.println(course.toString());
        int continueValue;
        if(lms.isEnrolled(course)){
            continueValue = 0;
            if (lms.isCompleted(course)) {
                while(true){
                    displayMenu(completedCourseMenu, "COURSE OPTIONS");
                    int userCommand;
                    if ((userCommand = menuCommandValidation(continueCourseMenu)) == -1) continue;
                    boolean quit = false;
                    switch(userCommand){
                        case(0):
                            viewGrades(course);
                            break;
                        case(1):
                            printCertificate(course);
                            return;
                        case(3):
                            //printTopicToFile();
                            break;
                        case(2):
                        quit = true;
                            break;
                    }
                    if (quit == true) break;
                }
                return;
            }
            else {
                while(true){
                    displayMenu(continueCourseMenu, "COURSE OPTIONS");
                    int userCommand;
                    if ((userCommand = menuCommandValidation(continueCourseMenu)) == -1) continue;
                    boolean quit = false;
                    switch(userCommand){
                        case(0):
                            continueCourse(course, lms.getCourseProgress(course.getTitle()));
                            break;
                        case(1):
                            viewGrades(course);
                            break;
                        case(2):
                            quit = true;
                            break;
                    }
                    if (quit == true) break;
                }
                return;
            }
        }
        else {
            while(true){
                displayMenu(newCourseMenu, "COURSE OPTIONS");
                int userCommand;
                if ((userCommand = menuCommandValidation(newCourseMenu)) == -1) continue;
                boolean quit = false;
                switch(userCommand){
                    case(0):
                        enrollCourse(course);
                        break;
                    case(1):
                        quit = true;
                        break;
                }
                if (quit == true) break;
            }
            return;
        }
    }

    public void enrollCourse(Course course) {
        System.out.println("\n-----Enrolling Course-----");
        lms.enrollCourse(course.getTitle());

        continueCourse(course, lms.getCourseProgress(course.getTitle()));

    }

    private void displayAllCourses() {
        clearScreen();
        System.out.println("\n-----Displaying All Courses-----");
        
        ArrayList<Course> allCourses = lms.getCourseList();
        System.out.println(lms.displayCourseList()+"\n");

        while (true) {
        
            displayMenu(courseListMenu, "ALL COURSE OPTIONS");

            int userCommand;
            if ((userCommand = menuCommandValidation(courseListMenu)) == -1) continue;

            switch(userCommand) {
                case(0):
                    while (true){
                        userCommand = getUserInt("Which course would you like to select? ") -1;
                        if (userCommand < 0 || userCommand >= allCourses.size()) continue;
                        break;
                    }
                    String courseChoice = allCourses.get(userCommand).getTitle();
                    Course course = lms.getCourseByTitle(courseChoice);
                    displayCourseDescription(course);
                    return;
                case(1):
                    return;
            }

        }

    }

    private void createCourse() {
        clearScreen();
        System.out.println("\n-----Creating Course-----");

        String courseName = getUserString("Course Name");

        String courseDescription = getUserString("Course Description");

        int difficulty;
        while (true) {

            displayMenu(difficultyMenu, "DIFFICULTY OPTIONS");

            if ((difficulty = menuCommandValidation(continueCourseMenu)) == -1) continue;
            break;
        }
    

        int topicNum = getUserInt("How many topics will this course have? ");

        ArrayList<Topic> topics = new ArrayList<Topic>();
        

        for (int i = 0; i < topicNum; i++) {

            String topicName = getUserString("Topic Name #" + (i + 1));

            int subtopicNum = getUserInt("How many subtopics will this topic have? ");

            ArrayList<Subtopic> subtopics = new ArrayList<Subtopic>();

            for (int j = 0; j < subtopicNum; j++) {

                String subtopicName = getUserString("Subtopic Name #" + (j + 1));
                String subtopicInfo = getUserString("Subtopic Information");

                Subtopic subtopic = new Subtopic(subtopicName, subtopicInfo);

                subtopics.add(subtopic);

            }
            
            int questionNum = getUserInt("How many questions will this quiz have? ");

            ArrayList<Question> questions = new ArrayList<Question>();

            for (int k = 0; k < questionNum; k++) {

                String questionContent = getUserString("Question #" + (k + 1));
    
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

        lms.makeCourse(topics, courseName, courseDescription, difficulty);

    }

    public void editCourse() {
        clearScreen();
        //toDo

    }

    private void viewProfile(User user) {
        clearScreen();
        System.out.println("\n-----Profile-----");
        System.out.println(user.toString());

        int userCommand;
        while (true) {
            
            displayMenu(profileMenu, "PROFILE OPTIONS");
            
            
           if ((userCommand = menuCommandValidation(profileMenu)) == -1) continue;

            break;
        }
    }

    private void viewBilling() {
        clearScreen();
        System.out.println("\n-----Billing-----");
        System.out.println("Free access to learning resources will be available until the end of 2025");
        
        int userCommand;
        while (true) {
            displayMenu(billingMenu, "BILLING OPTIONS");

            
            if ((userCommand = menuCommandValidation(billingMenu)) == -1) continue;
            break;
        }
    }

    private void logOut() {
        clearScreen();
        System.out.println("See ya!");
        lms.logout();
    }

    public void commentTopic(Topic topic){
        addComment(topic.getComments());
    }

    public void addComment(ArrayList<Comment> comments){
        
            String commentInfo = getUserString("Comment");
            Comment comment = new Comment(commentInfo, lms.getCurrentUser().getUsername(), lms.getCurrentUser().id);

            comments.add(comment);

        
    }

    public void displayComments(ArrayList<Comment> comments){
        //clearScreen();
        String result = "";
        if(comments == null)
            result = "No comments on this thread.";
        else {
            int position = 1;
            for(Comment comment : comments){
                result += Integer.toString(position)+". "+comment.toString()+"\n";
                if (comment.getReplies() != null) 
                    result += "     "+comment.getReplies().size() + " replies" + "\n\n";
                position++;
            }

        }
        System.out.println(result);

        commentInteraction(comments);
    }

        

        
            

        
    public void commentInteraction(ArrayList<Comment> comments) {
        //clearScreen();
        int userCommand;
        while (true) {
            displayMenu(commentMenu, "COMMENT OPTIONS");
            if ((userCommand = menuCommandValidation(commentMenu)) == -1) continue;
            break;
        }
        int commentChoice;
        switch(userCommand) {
            case(0):
                addComment(comments);
                break;
            case(1):
                if (comments == null) {
                    System.out.println("No comments to comment on");
                    break; 
                } 
                while (true) {

                    commentChoice = getUserInt("Which comment do you want to view replies? ") - 1;
                    if (commentChoice < 0 || commentChoice >= comments.size()) {
                        System.out.println("Invalid");
                        continue;
                    }
                    break;
                }

                displayComments(comments.get(commentChoice).getReplies());
                break;
            case(2):
                
                
        }
 
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");  //clear the consle 
        System.out.flush();  //clear the consle
    }

    public void viewGrades(Course course) {
        clearScreen();

    }

    public void printCertificate(Course course) {

        System.out.println("\n-----Printing Certificate-----");
        lms.printCertificate(course);
        System.out.println("\n-----Success! Redirecting Home-----");



    }
        
    public void viewTopics(Course course) {
        ArrayList<Topic> topics = lms.getTopics(course);
        System.out.println(course.displayTopics());




    }


    public void printTopicToFile(Topic topic){
        clearScreen();
        lms.printToFileTopic(topic);
    }


    public static void main(String[] args) {
        LMSUI lmsInterface = new LMSUI();
        lmsInterface.run();
    
    }

}
