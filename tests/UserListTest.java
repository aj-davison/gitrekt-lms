package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.*;

public class UserListTest {
    private UserList userList = UserList.getInstanceUserList();
    private ArrayList<User> users = userList.getUsers();

    @BeforeEach
	public void setup() {
        users.clear();
		users.add(new Student("Robert", "Smith", "rsmith@gmail.com", "rsmitty", "password"));
		users.add(new Student("Will", "Ross", "wross@gmail.com", "wross", "12345"));
		DataWriter.saveUsers();
	}

	@AfterEach
	public void tearDown() {
		UserList.getInstanceUserList().getUsers().clear();
		DataWriter.saveUsers();
	}

	@Test
	void testLoginEmailFirstItem() {
		boolean loginRob = false;
		if(users.get(0).getEmail().equals(userList.loginE("rsmith@gmail.com", "password").getEmail())){
			loginRob = true;
		}
		assertTrue(loginRob);
	}

	@Test
	void testLoginEmailInvalidPasswordFirst() {
		boolean loginRob = false;
		if(userList.loginE("rsmith@gmail.com", "wrong") != null &&
		users.get(0).getEmail().equals(userList.loginE("rsmith@gmail.com", "wrong").getEmail())){
			loginRob = true;
		}
		assertFalse(loginRob);
	}

	@Test
	void testLoginEmailLastItem() {
		boolean loginWill = false;
		if(users.get(1).getEmail().equals(userList.loginE("wross@gmail.com", "12345").getEmail())){
			loginWill = true;
		}
		assertTrue(loginWill);
	}

	@Test
	void testLoginEmailInvalidPasswordLast() {
		boolean loginWill = false;
		if(userList.loginE("wross@gmail.com", "wrong") != null &&
		users.get(1).getEmail().equals(userList.loginE("wross@gmail.com", "wrong").getEmail())){
			loginWill = true;
		}
		assertFalse(loginWill);
	}

	@Test
	void testLoginUsernameFirstItem() {
		boolean loginRob = false;
		if(users.get(0).getUsername().equals(userList.loginU("rsmitty", "password").getUsername())){
			loginRob = true;
		}
		assertTrue(loginRob);
	}

	@Test
	void testLoginUsernameLastItem() {
		boolean loginWill = false;
		if(users.get(1).getUsername().equals(userList.loginU("wross", "12345").getUsername())){
			loginWill = true;
		}
		assertTrue(loginWill);
	}

	@Test
	void testLoginUsernameInvalidPasswordFirst() {
		boolean loginRob = false;
		if(userList.loginU("rsmitty", "wrong") != null &&
		users.get(0).getUsername().equals(userList.loginU("rsmitty", "wrong").getUsername())){
			loginRob = true;
		}
		assertFalse(loginRob);
	}

	@Test
	void testLoginUsernameInvalidPasswordLast() {
		boolean loginRob = false;
		if(userList.loginU("rsmitty", "wrong") != null &&
		users.get(0).getUsername().equals(userList.loginU("rsmitty", "wrong").getUsername())){
			loginRob = true;
		}
		assertFalse(loginRob);
	}

	@Test
	void testLoginEmailNull() {
		boolean login = false;
		if(userList.loginE(null, null) != null){
			login = true;
		}
		assertFalse(login);
	}

	@Test
	void testLoginUsernameNull() {
		boolean login = false;
		if(userList.loginU(null, null) != null){
			login = true;
		}
		assertFalse(login);
	}

	@Test
	void testSignUpStudent() {
		boolean signUp = false;
		userList.signUp("John", "Doe", "jdoe", "password", "jdoe@gmail.com", 0);
		if(users.get(2).getUsername().equals("jdoe")){
			signUp = true;
		}
		assertTrue(signUp);
	}

	@Test
	void testSignUpNull() {
		boolean signUp = false;
		userList.signUp(null, null, null, null, null, 0);
		if(users.get(2) != null){
			signUp = true;
		}
		assertFalse(signUp);
	}

	@Test
	void testSignUpEmpty() {
		boolean signUp = false;
		userList.signUp("", "", "", "", "", 0);
		if(users.get(2) != null){
			signUp = true;
		}
		assertFalse(signUp);
	}

	


}
