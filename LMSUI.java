import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class LMSUI {

    private static final String WELCOME_MESSAGE = "Welcome to our Coding LMS :)";
    private String[] loginMenu = {"Login with Username", " Login with Email", "Create Account"};
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

            int userCommand = getUserCommand(loginMenu.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}

            if(userCommand == loginMenu.length) break;

            User user;
            //have switch return an user
            //if it does, continue to next while loop
            //if it doesn't keep them in login while loop

            switch(userCommand) {
                case(0):
                    user = loginU();
                    if (user != null)
                        break;
                case(1):
                    user = loginE();
                    if (user != null)
                        break;
                case(2):
                    user = createAccount();;
                    if (user != null) 
                    break;
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

        User user = lms.loginU(username, password);
        return user;

    }

    private User loginE() {

        System.out.println("\n-----Loging in-----");        

        String email = getUserString("Email");
        String password = getUserString("Password");
        
        System.out.println(email + " " + password);

        User user = lms.loginE(email, password);
        return user;

    }

    private void createAccount() {
        System.out.println("\n-----Signing Up-----");        

        String firstName = getUserString("First Name");
        String lastName = getUserString("Last Name");
        String email = getUserString("Email");
        String username = getUserString("Username");
        String password = getUserString("Password");


        User user = lms.signUp(firstName, lastName, username, password, email);



        


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

    public static void main(String[] args) {
        LMSUI lmsInterface = new LMSUI();
        lmsInterface.run();
    
    }

}

