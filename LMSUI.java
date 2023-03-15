import java.util.Scanner;

public class LMSUI {

    private static final String WELCOME_MESSAGE = "Welcome to our Coding LMS :)";
    private String[] loginMenu = {"Login In", "Create Account"};
    private String[] homeMenu = {"Display Current Courses","Search Courses", "Display All Courses", "View Profile", "Billing Page", "Log Out"};
    private String[] createAccountMenu = {"Student", "Author"};
    private String[] courseMenu = {"Enter Course", "Exit to Home"};
    private String[] topicMenu = {"Next", "Previous", "Display Comments", "Exit to Home"};
    private String[] commentMenu = {"Comment", "Comment on a Comment", "Next Topic", "Exit to Home"};
    private String[] basicMenu = {"Exit to Home"};
    private String[] quizMenu = {"Next Toipic", "Exit to Home"};
    private Scanner scanner;
    private LMS lms;

    LMSUI() {
        scanner = new Scanner(System.in);
        lms = new LMS();
    }

    public void run() {
        System.out.println(WELCOME_MESSAGE);

        while(true) {
            
            displayMenu(loginMenu, "LOG IN");

        }
    }

    private void displayMenu(String[] menu, String pageName) {
        System.out.println("\n****** " + pageName + " ******");
        for (int i=0; i < menu.length; i++) {
            System.out.println((i+1) + ". " + menu[i]);
        }
        System.out.println("\n");
    }



}