import java.util.ArrayList;
import java.util.UUID;

public class Comment {
    private ArrayList<Comment> subComments;
    private String mainComment;
    private UUID userID;

    public Comment(String mainComment, String username){

    }
    public String toString(){
        return "";
    }
    public void addSubComment(Comment subComment){
        
    }
    public Object getContent() {
        return mainComment;
    }
    public UUID getUserID() {
        return this.userID;
    }
    public ArrayList getReplies() {
        if(subComments == null)
            return null;
        else
            return this.subComments;
    }
}
