import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;

    public Quiz(ArrayList<Question> questions){

    }
    public void addQuestion(Question question){

    }
    public String toString(){
        return "";
    }
    public ArrayList<Question> getQuestions() {
        if(questions == null)
            return null;
        else
            return this.questions;
    }
}
