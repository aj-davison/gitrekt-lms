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
        if(questions == null){
            questions = new ArrayList<Question>();
            return questions;
        }
        else
            return this.questions;
    }
}
