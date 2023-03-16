import java.util.ArrayList;

public class Question {
    private String question;
    private String[] answers;
    private static final int NUM_ANS = 4;
    private int correct_ans;

    public Question(String question, String[] answers, int isAns){

    }
    public String displayQuestion(){
        return "";
    }
    public boolean isCorrect(int ans){
        return true;
    }
    public String displayAnswers(){
        return "";
    }
    public String displayCorrect(){
        return "";
    }
    public Object getQuestion() {
        return this.question;
    }
    public int getCorrect() {
        return correct_ans;
    }
    public String[] getAns() {
        if(answers == null)
            return null;
        else
            return this.answers;
    }
}
