import java.util.ArrayList;
import java.util.UUID;

public class Comment {
    private ArrayList<Comment> subComments;
    private String mainComment;
    private String username;
    private UUID UserID;

    public Comment(String mainComment, String username){
        this.mainComment = mainComment;
        this.username = username;
        subComments = new ArrayList<>();
    }
    public Comment(UUID UserID, String mainComment, String username, ArrayList<Comment> subComments){
        this.mainComment = mainComment;
        this.username = username;
        this.subComments = subComments;
        this.UserID = UserID;
    }
    //TODO
    public String toString(){
        return "";
    }
    public void addSubComment(Comment subComment){
        subComments.add(subComment);
    }
    public String getContent() {
        return this.mainComment;
    }
    public String getUsername(){
        return this.username;
    }
    public UUID getID() {
        return this.UserID;
    }
    public ArrayList<Comment> getReplies() {
        if(subComments == null)
        {
            subComments = new ArrayList<Comment>();
            return subComments;
        }  
        else
            return this.subComments;
    }
}
