import java.util.UUID;

import javax.lang.model.util.ElementScanner14;

import java.util.ArrayList;

public class Student extends User{
    private int topicsCompleted;
    private ArrayList<Double> grades;

    public Student(String firstName, String lastName, String email, String username, String password){
        super(firstName, lastName, email, username, password);
        this.topicsCompleted = 0;
        grades = new ArrayList<>();
        
    }
    public Student(UUID id, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password, int topicsCompleted, ArrayList<Double> grades){
        super(id, courseProgresses, firstName, lastName, email, username, password);
        this.topicsCompleted = topicsCompleted;
        this.grades = grades;
    }
    public void enrollCourse(Course course){
        //TODO       
        CourseProgress courseProgress = new CourseProgress(course, null, topicsCompleted);
        this.addCourseProgress(courseProgress);
    }
    public void continueCourse(Course course){

    }
    public void unregisterCourse(Course course){
        
    }
    public int getTopicsCompleted() {
        return this.topicsCompleted;  
    }

    public ArrayList getGrades(){
        if(this.grades == null){
            grades = new ArrayList<Double>();
            return grades;
        }
        else
            return this.grades;
    }
}
