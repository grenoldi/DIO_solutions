import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


class Template{
  
  public static void main(String[] args) {
    String filename = "";
    try{
      if(args.length > 0){
        filename = new String(args[0]);
        System.out.println("Using input file " + filename);
      }
      Scanner reader = new Scanner(new File(filename));
      FileWriter writer = new FileWriter(new File("saida_"+filename));
      
      // insert code below
      
      reader.close();
      writer.close();
    }
      catch (IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
