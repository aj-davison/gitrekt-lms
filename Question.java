import java.util.ArrayList;

public class Question {
    private String question;
    private String[] answers;
    private static final int NUM_ANS = 4;
    private int correct_ans;
    private boolean correct;

    public Question(String question, String[] answers, int correct_ans){
        this.question = question;
        for (int i=0; i<NUM_ANS; i++){
            this.answers[i] = answers[i];
        }
        this.correct_ans = correct_ans;
        this.correct = false; 
    }
    public String getQuestion(){
        return this.question;
    }
    public void isCorrect(int ans){
        if (ans == this.correct_ans){
            this.correct = true;
        } else {
            this.correct = false;
        }
    }
    public int updateScore(){
        int score = 0;
        if(this.correct){
            score++;
        }
        this.correct = false;
        return score;
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
