import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Substring {
  
  public static int present(String sub, String master){
    System.out.println(""+sub+" "+master);
    if (master.contains(sub)){
      return sub.length();
    }
    return 0;
  }
  
  public static void main(String[] args) {
    String filename = new String();
    String substr;
        
    int num1, num2, max, tamanho;
    
    try{
        if(args.length > 0){
          filename = new String(args[0]);
          System.out.println("Using input file " + filename);
        }
        Scanner sc = new Scanner(new File(filename));
        FileWriter writer = new FileWriter(new File("saida_"+filename));
        String firstword = sc.nextLine();
        String secondword = sc.nextLine();
        
        while(!firstword.equals("")){
          num1 = firstword.length();
          max = 0;
          if(firstword.equals(secondword)) max = firstword.length();
          else{
            if(num1 == 1){
              substr = new String(firstword);
              if(present(substr, secondword) > 0) max = present(substr, secondword);
            }
            else{
              for(int n = 1; n < num1+1; n++){
                for (int i = 0; i < num1-n+1; i++){
                  substr = new String(firstword.substring(i, i+n));
                  tamanho = present(substr, secondword); 
                  if(tamanho > 0 && tamanho > max) max = tamanho;
                }
              }
            }
          }
          
          writer.write(String.valueOf(max));
            firstword = new String (sc.nextLine());
            secondword = new String (sc.nextLine());
          } catch(NoSuchElementException e){
            firstword = "";
          }
        }
        sc.close();
        writer.close();
    } catch (IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}