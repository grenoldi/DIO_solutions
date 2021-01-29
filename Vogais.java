import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Vogais {
  
  public static void main(String[] args) {
    String filename = new String();
    String str_vogais, frase;
    String[] vogais;
    int num_vogais = 0, tamanho;
    
    try{
        if(args.length > 0){
          filename = new String(args[0]);
          System.out.println("Using input file " + filename);
        }
        Scanner sc = new Scanner(new File(filename));
        FileWriter writer = new FileWriter(new File("saida_"+filename));
        
        str_vogais = sc.nextLine();
        frase = sc.nextLine();
        
        while(!str_vogais.equals("")){
          vogais = str_vogais.split("");
          tamanho = frase.length();
          num_vogais = 0;
          for(String vogal : vogais){
              for(int i = 0; i < tamanho; i++){
                  if(vogal.equals(frase.substring(i, i+1))){
                    num_vogais++;
                    //System.out.println(num_vogais);
                  }
              } 
          }
          writer.write(String.valueOf(num_vogais));
          writer.write("\n");
          try{
            str_vogais = new String (sc.nextLine());
            frase = new String (sc.nextLine());
          } catch(NoSuchElementException e){
            str_vogais = "";
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