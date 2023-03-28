import java.util.ArrayList;
import java.io.*;
import java.util.Formatter;


//2 mehtods to pring out the info for any topic 
// to print out the course certificate

public class LMSFileWriter {
    
    public static void writeCourseCertificate(Course course){
        String title = "CousreCertificate"+course.getTitle();
        try { 
            Formatter f = new Formatter(title+".txt");
            f.

            FileWriter myWriter = new FileWriter(title+".txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred trying to create your course certificate");
            e.printStackTrace();
          }
    }
}
