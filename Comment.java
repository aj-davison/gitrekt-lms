import java.util.ArrayList;
import java.util.UUID;

public class Comment {
    private ArrayList<Comment> subComments;
    private String mainComment;
    private String username;
    private UUID userID;

    public Comment(String mainComment, String username, UUID userId){
        this.mainComment = mainComment;
        this.username = username;
        this.userID = userId;
        subComments = new ArrayList<>();
    }

    public Comment(UUID userID, String mainComment, String username, ArrayList<Comment> subComments){
        this.mainComment = mainComment;
        this.username = username;
        this.subComments = subComments;
        this.userID = userID;
    }

    //TODO
    public String toString(){
        return "comment";
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
        return this.userID;
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
