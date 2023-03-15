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
                    users.add(new Student(null, firstName, lastName, username, password, email));
                } else {
                    users.add(new Author(null, null, firstName, lastName, username, password, email));
                }
            }
            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        ArrayList<User> test = getUsers();
        for(int i=0;i<test.size();i++) {
            System.out.print(test.get(i).getUsername());
            System.out.println();
        }
    }
}
