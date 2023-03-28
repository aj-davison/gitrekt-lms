import java.util.ArrayList;
import java.util.UUID;

public class CourseProgress {
    private Course course; // The unique identifier for this course progress.
    private ArrayList<Double> grades; // The list of grades associated with the given course
    
    /**
    *Constructs a new CourseProgress object with the specified UUID and list of grades.
    *@param id the unique identifier for this course progress.
    *@param grades the list of grades associated with the given course
    */
    public CourseProgress(Course course, ArrayList<Double> grades) {
        this.course = course;
        this.grades = grades;
    }
    public CourseProgress(Course course){
        this.course = course;
        this.grades = new ArrayList<>();
    }

    public boolean isCompleted(Course course){
        boolean result = false;
        if(course.getTopics().size() == this.grades.size()){
            result = true;
        }
        return result;
    }

    /**
    *Returns a string representation of this CourseProgress object
    *@return a string representation of this CourseProgress object
    */
    public String toString() {
        return this.course.toString();
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

    public String displayTopicGrades(){
        String result = "";
        int position = 1;
        for(Double grade : this.grades){
            Double percent = grade*100;
            result += Integer.toString(position)+". "+Double.toString(percent)+"%\n";
            position++;
        }
        return result;
    }

    /**
    *Returns the UUID associated with this course progress.
    *@return the UUID associated with this course progress.
    */
    public Course getCourse() {
        return this.course;
    }

    /**
    Returns the number of completed topics for this course progress.
    @return the number of completed topics for this course progress.
    */
    public int numCompletedTopics(){
        return this.grades.size();
    }
    
}
