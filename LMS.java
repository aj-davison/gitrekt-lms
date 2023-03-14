public class LMS {
    private User currentUser;
    private Course currentCourse;

    public void loginE(String email, String password){

    }
    public void loginU(String usernam, String password){

    }
    public void logout(){

    }
    public User signUp(ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String username, String password, String email){
        Student user = new Student(null, firstName, lastName, email, username, password);
        return user;
    }
}
