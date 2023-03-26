import java.util.ArrayList;
import java.util.UUID;

public class CourseProgress {
    private UUID id; // The unique identifier for this course progress.
    private ArrayList<Double> grades; // The list of grades associated with the given course
    
    /**
    *Constructs a new CourseProgress object with the specified UUID and list of grades.
    *@param id the unique identifier for this course progress.
    *@param grades the list of grades associated with the given course
    */
    public CourseProgress(UUID id, ArrayList<Double> grades) {
        this.id = id;
        this.grades = grades;
    }
    public CourseProgress(UUID id){
        this.id = id;
        this.grades = new ArrayList<Double>();
    }

    /**
    *Returns a string representation of this CourseProgress object
    *@return a string representation of this CourseProgress object
    */
    public String toString() {
        return "CourseProgress";
    }

    /**
    *Adds a grade to the list of grades associated with this course progress
    *@param grade the grade to add to the list of grades.
    */
    public void addGrade(double grade){
        this.grades.add(grade);
    }

    /**
    *Returns the average grade for this course progress.
    *@return the average grade for this course progress.
    */
    public Double getGrade(){
        int questions = this.grades.size();
        double grade = 0;
        for(double score : grades) {
        grade += score;
        }
        grade /= questions;
        return grade;
    }

    /**
    *Returns the list of grades associated with the given course.
    *@return the list of grades associated with the given course
    */
    public ArrayList<Double> getGrades(){
        return this.grades;
    }

    /**
    *Returns the UUID associated with this course progress.
    *@return the UUID associated with this course progress.
    */
    public String getID() {
        return this.id.toString();
    }

    /**
    Returns the number of completed topics for this course progress.
    @return the number of completed topics for this course progress.
    */
    public int numCompletedTopics(){
        return this.grades.size();
    }
    
}
