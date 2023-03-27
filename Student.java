import java.util.UUID;

import javax.lang.model.util.ElementScanner14;

import java.util.ArrayList;

public class Student extends User{

    private String type = "Student";
    
    public Student(String firstName, String lastName, String email, String username, String password){
        super(firstName, lastName, email, username, password);
    }
    public Student(UUID id, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
        super(id, courseProgresses, firstName, lastName, email, username, password);
    }
    public void enrollCourse(Course course){  
        CourseProgress courseProgress = new CourseProgress(course, null);
        this.addCourseProgress(courseProgress);
    }
    public void unregisterCourse(Course course){
        courseProgresses.remove(course);
    }
    /* 
    public ArrayList<Double> getGrades(Course course) {
        ArrayList<Double> grades  = new ArrayList<Double>();
        for(int i=0; i<courseProgresses.size(); i++){
            if()
            grades.add(courseProgresses.get(i).getGrades());
        }
        return grades;
    }
    */

    public String toString(){
        String result = "";
        if(this.courseProgresses == null){
            courseProgresses = new ArrayList<CourseProgress>();
            return result;
        }
        
        result += "Name: "+this.firstName+" "+this.lastName+"\n";
        result += "Username: "+this.username+"\n";       
        result += "Password: "+this.password+"\n";
        result += "Email: "+this.email+"\n";
        result += "Type: "+this.type+"\n";
        result += "Courses: ";
        for (CourseProgress courseProgress : courseProgresses){
            result += courseProgress.toString()+", ";
        }
        result += "\n";
        return result;
    }
}
