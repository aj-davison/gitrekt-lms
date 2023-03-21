import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class LMSUI {

    private static final String WELCOME_MESSAGE = "Welcome to our Coding LMS :)";
    private String[] loginMenu = {"Login with Username", "Login with Email", "Create Account", "Quit"};
    private String[] userTypeMenu = {"Student", "Author"};
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

        boolean loginFlag = true;

        while(loginFlag == true) {
            
            displayMenu(loginMenu, "LOG IN");

            int userCommandLogin = getUserCommand(loginMenu.length);
			
			if(userCommandLogin == -1) {
				System.out.println("Not a valid command");
				continue;
			}

            if(userCommandLogin == loginMenu.length) break;

            User user;
            //have switch return an user
            //if it does, continue to next while loop
            //if it doesn't keep them in login while loop
            boolean quit = false;
            switch(userCommandLogin) {
                case(0):
                    user = loginU();
                    if (user == null) {
                        System.out.println("Invalid Information");
                        break;
                    }
                case(1):
                    user = loginE();
                    if (user == null) {
                        System.out.println("Invalid Information");
                        break;
                    }
                case(2):
                    user = createAccount();
                    if (user == null) {
                        System.out.println("Invalid Information");
                        break;
                    }
                case(3):
                    quit = true;
                    break;
            }
            if (quit == true) break;

            displayMenu(homeMenu, "HOME PAGE");

            int userCommandHome = getUserCommand(homeMenu.length);
			
			if(userCommandHome == -1) {
				System.out.println("Not a valid command");
				continue;
			}

            if(userCommandHome == homeMenu.length) break;

            while (true) {
                switch (userCommandHome) {
                    case(0):
                        displayCurrentCourses();
                        break;
                    case(1):
                        searchCourses();
                        break;
                    case(2):
                        displayAllCourses();
                        break;
                }


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
		System.out.print("What would you like to do?: ");
		
		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1)
            return command;
		
		return -1;

	}

    private User loginU() {

        System.out.println("\n-----Loging in-----");        

        String username = getUserString("Username");
        String password = getUserString("Password");
        
        System.out.println(username + " " + password);

        
        return lms.loginU(username, password);

    }

    private User loginE() {

        System.out.println("\n-----Loging in-----");        

        String email = getUserString("Email");
        String password = getUserString("Password");
        
        System.out.println(email + " " + password);

        return lms.loginE(email, password);

    }

    private User createAccount() {
        System.out.println("\n-----Signing Up-----");        

        String firstName = getUserString("First Name");
        String lastName = getUserString("Last Name");
        String email = getUserString("Email");
        String username = getUserString("Username");
        String password = getUserString("Password");
       
        displayMenu(userTypeMenu, "Account Type");

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
        
    }

    private void viewProfile() {
        
    }

    private void viewBilling() {
        
    }

    private void logOut() {
        
    }

    public static void main(String[] args) {
        LMSUI lmsInterface = new LMSUI();
        lmsInterface.run();
    
    }

}

