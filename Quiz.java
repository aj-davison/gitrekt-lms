import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions = new ArrayList<Question>();

    public Quiz(ArrayList<Question> questions){
        this.questions = questions;
    }
    public void addQuestion(Question question){
        questions.add(question);
    }
    public ArrayList<Question> getQuestions() {
        if(questions == null){
            questions = new ArrayList<Question>();
            return questions;
        }
        else
            return this.questions;
    }
    public String toString(){
        return "";
    }
}
