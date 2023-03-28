import java.util.ArrayList;
import java.io.*;
import java.util.Formatter;


//2 mehtods to pring out the info for any topic 
// to print out the course certificate

public class LMSFileWriter {
    
    public static void writeCourseCertificate(String courseTitle, Double Grade, String FirstName, String LastName){
        String title = "CousreCertificate"+courseTitle;
        String FullName = FirstName+" "+LastName;
        try { 
            Formatter f = new Formatter(title+".txt");
            //f.format("%30s%n%n", ""); // center-align the next line
            f.format("%30s%n", "Certificate of completion: "+courseTitle); // center-align text
            //f.format("%30s%n%n", ""); // center-align the next line
            //f.format("%-15s", "Name:");
            f.format("<b>%s</b>%n", FullName); // bold text
            ///f.format("%-15s", "Age:");
            f.format("%30s%n", "Grade: "+Grade); // center-align text
            f.close();
          } catch (IOException e) {
            System.out.println("An error occurred trying to create your course certificate");
            e.printStackTrace();
          }
    }



    public static void topicToFile(){
      String title = "  ";
      try { 
          Formatter f = new Formatter(title+".txt");
         
          f.close();
        } catch (IOException e) {
          System.out.println("An error occurred trying to create your course certificate");
          e.printStackTrace();
        }
  }



}
