import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private  ArrayList<User> users;

    private UserList(){
        //userlist = DataLoader.getUsers();
    }

    public static UserList getInstanceUserList(){
        if(userList == null){
            //creating new users list
            userList = new UserList();
        }
        return userList;
    }
    public void addUser(ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){

    }
    public User getUser(String username){
        Student user = new Student(null, null, null, null, null, null);
        return user;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void editUser(/*TODO*/){

    }

    public void saveUsers(){
        
    }
}
