import java.util.ArrayList;

public class Question {
    private String question;
    private String[] answers;
    private static final int NUM_ANS = 4;
    private int correctAns;
    private boolean correct;

    public Question(String question, String[] answers, int correctAns){
        this.question = question;
        for (int i=0; i<NUM_ANS; i++){
            this.answers[i] = answers[i];
        }
        this.correctAns = correctAns;
        this.correct = false; 
    }

    public String getQuestion(){
        return this.question;
    }

    public void isCorrect(int ans){
        if (ans == this.correctAns){
            this.correct = true;
        } else {
            this.correct = false;
        }
    }

    public int score(){
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
        return correctAns;
    }
    
    public String[] getAns() {
        if(answers == null)
            return null;
        else
            return this.answers;
    }
}
