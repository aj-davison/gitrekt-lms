import java.util.ArrayList;

public class Question {
    private String question;
    private String[] answers;
    private static final int NUM_ANS = 4;
    private int correct_ans;

    public Question(String question, String[] answers, int correct_ans){
        this.question = question;
        for (int i=0; i<NUM_ANS; i++){
            this.answers[i] = answers[i];
        }
        this.correct_ans = correct_ans; 
    }
    public String getQuestion(){
        return this.question;
    }
    public boolean isCorrect(int ans){
        boolean result;
        if (ans == this.correct_ans){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    public String displayAnswers(){
        String result = "";
        result += "1. "+this.answers[0]+"\n";
        result += "2. "+this.answers[1]+"\n";
        result += "3. "+this.answers[2]+"\n";
        result += "4. "+this.answers[3]+"\n";
        return result;

    }
    public String displayCorrect(){
        return "Correct!";
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
