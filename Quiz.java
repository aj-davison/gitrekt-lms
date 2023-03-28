import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions; 

    public Quiz(ArrayList<Question> questions){
        this.questions = questions;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public boolean equals(Quiz quiz){
        boolean result = false;
        int position = 0;
        int numMatchingQuestions = 0;
        for(Question question : this.questions){
            if(question.equals(quiz.getQuestionAt(position))){
                numMatchingQuestions++;
            }
            position++;
        }
        if(numMatchingQuestions == questions.size()){
            result = true;
        }
        return result;
    }

    public ArrayList<Question> getQuestions() {
        if(questions == null){
            questions = new ArrayList<Question>();
            return questions;
        }
        else
            return this.questions;
    }

    public Question getQuestionAt(int index){
        if(questions != null)
            return questions.get(index);
        else
            return null;
    }

    //TODO
    public String toString(){
        String result = "**QUIZ**\n";
        for(Question question : this.questions){
            result += question.toString()+"\n";
        }
        return result;
    }
    
    public double getGrade(){
        int score = 0;
        for(Question question : questions){
            score += question.score();
        }
        double grade;
        grade = score/questions.size();
        return grade;
    }

    public int getQuizSize(){
        return questions.size();
    }
}
