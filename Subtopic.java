public class Subtopic {
    private String name;
    private String info;

    public Subtopic(String name, String info){
        this.name = name;
        this.info = info;
    }

    
    //We will have to do some serious formatting to get this to print out a paragraph instead of a line.
    //will fix later when we think about what format the info is in.   
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
