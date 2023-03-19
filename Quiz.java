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
    //TODO
    public String toString(){
        return "";
    }
    public int score(){
        int score = 0;
        for(Question question : questions){
            if(question.){
                score++;
            }
        }
        return score;
    }
}
