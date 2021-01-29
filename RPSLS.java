import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// marcia = 1 e fernanda = 2

public class RPSLS {
  
  public static int rpslsPlay(String str1, String str2){
    if(str1.equals(str2)) return 0;
    else if(str1.equals("tesoura") && (str2.equals("papel") || str2.equals("lagarto"))) return 2;
    else if(str1.equals("papel") && (str2.equals("spock") || str2.equals("pedra"))) return 2;
    else if(str1.equals("pedra") && (str2.equals("lagarto") || str2.equals("tesoura"))) return 2;
    else if(str1.equals("lagarto") && (str2.equals("spock") || str2.equals("papel"))) return 2;
    else if(str1.equals("spock") && (str2.equals("tesoura") || str2.equals("pedra"))) return 2;
    else return 1;
  }
  
  public static void main(String[] args) {
      String filename = new String();
    try{
        if(args.length > 0){
          filename = new String(args[0]);
          System.out.println("Using input file " + filename);
        }
        Scanner sc = new Scanner(new File(filename));
        FileWriter writer = new FileWriter(new File("saida_"+filename));
        String[] entrada;
        int resultado, num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++){
          entrada = sc.nextLine().split(" ");
          resultado = rpslsPlay(entrada[0], entrada[1]); 
          if(resultado == 0){
            writer.write("empate");
            writer.write("\n");
          }
          
          else if(resultado == 1){
            writer.write("sheldon");
            writer.write("\n");
          }
          
          else if(resultado == 2){
            writer.write("rajesh");
            writer.write("\n");
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