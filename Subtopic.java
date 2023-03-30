/**
 * A subtopic class
 * @author Andrew Davison
 */
public class Subtopic {
    private String name;
    private String info;

    /**
     * Creates an instance of a subtopic
     * @param name The name of the subtopic
     * @param info The info inside the subtopic
     */
    public Subtopic(String name, String info){
        this.name = name;
        this.info = info;
    }

    
    //We will have to do some serious formatting to get this to print out a paragraph instead of a line.
    //will fix later when we think about what format the info is in.

    /**
     * Prints the topic to a string
     * @return A string that represents the subtopic
     */
    public String toString(){
        String result = "";
        result += this.name+"\n";
        result += this.info+"\n";
        return result;
    }
    public String getName() {
        return this.name;
    }
    public String getInfo() {
        return this.info;
    }
}
