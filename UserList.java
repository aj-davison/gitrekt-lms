import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList(){
        users = DataLoader.getUsers();
    }


    public User getUserByUUID(UUID id){
        for (int i=0; i<users.size(); i++){
            if(users.get(i).getID().equalsIgnoreCase(id.toString())){
                return users.get(i);
            }
        }
        return null;
    }
    public User getUserByEmail(String email){
        for (int i=0; i<users.size(); i++){
            if(users.get(i).getEmail().equalsIgnoreCase(email)){
                return users.get(i);
            }
        }
        return null;
    }
    public User getUserByUsername(String username){
        for (int i=0; i<users.size(); i++){
            if(users.get(i).getUsername().equalsIgnoreCase(username)){
                return users.get(i);
            }
        }
        return null;
    }

    
    public static UserList getInstanceUserList(){
        if(userList == null){
            //creating new users list
            userList = new UserList();
        }
        return userList;
    }
    public void addStudent(String firstName, String lastName, String email, String username, String password){
        users.add(new Student(firstName, lastName, email, username, password));
    }
    public void addAuthor(String firstName, String lastName, String email, String username, String password){
        users.add(new Author(firstName, lastName, email, username, password));
    }
    public ArrayList<User> getUsers(){
        return users;
    }
    public void saveUsers(){
        DataWriter.saveUsers();
    }
    public User loginE(String email, String password){
        User user = getUserByEmail(email);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
