import java.util.ArrayList;
import java.util.UUID;

public class Comment {
    private ArrayList<Comment> subComments;
    private String mainComment;
    private String username;
    private UUID id;

    public Comment(String mainComment, String username){
        this.mainComment = mainComment;
        this.username = username;
        subComments = new ArrayList<>();
    }
    public Comment(UUID id, String mainComment, String username, ArrayList<Comment> subComments){
        this.mainComment = mainComment;
        this.username = username;
        this.subComments = subComments;
        this.id = id;
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
        return this.id;
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
