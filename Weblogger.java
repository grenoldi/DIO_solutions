import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Weblogger {
  public static final String ITALIC_TAG_START = "<i>";
  public static final String ITALIC_TAG_ENDING = "</i>";
  public static final String BOLD_TAG_START = "<b>";
  public static final String BOLD_TAG_ENDING = "</b>";
  
  
  public static void main(String[] args) {
    
    String entrada, saida, substr, filename = "";
    boolean istart = false;
    boolean bstart = false;
    int num;
    try{
        if(args.length > 0){
          filename = new String(args[0]);
          System.out.println("Using input file " + filename);
        }
        Scanner sc = new Scanner(new File(filename));
        FileWriter writer = new FileWriter(new File("saida_"+filename));
        while (sc.hasNextLine()){
          entrada = new String(sc.nextLine());
          saida = new String();
          substr = new String();
          num = entrada.length();
          for(int i = 0; i < num; i++){
            if(entrada.charAt(i) == '_'){
              if(istart){
                entrada = entrada.replaceFirst("_", ITALIC_TAG_ENDING);
                istart = false;
              }
              else{
                entrada = entrada.replaceFirst("_", ITALIC_TAG_START);
                istart = true;
              }
            }
            
            if(entrada.charAt(i) == '*'){
              if(bstart){
                entrada = entrada.replaceFirst("\\*", BOLD_TAG_ENDING);
                bstart = false;
              }
              else{
                entrada = entrada.replaceFirst("\\*", BOLD_TAG_START);
                bstart = true;
              }
            }
            num = entrada.length();
          }// for
          writer.write(entrada);
          writer.write("\n");
        }// while
        sc.close();
        writer.close();
      } catch (IOException e){
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  }
}