import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Conjuntos{
  public static boolean goodSet(String[] set){
    int setsize = set.length, wordsize;
    for (int i = 0; i < setsize; i++){
      wordsize = set[i].length();
      for(int j = 0; j < setsize; j++){
        System.out.printf("%s %s\n", set[i], set[j].substring(0, (wordsize - 1)));
        if(j!=i && set[j].length() >= wordsize && set[j].substring(0, (wordsize)).equals(set[i])){
          return false;
        }
      }
    }
    return true;
  }
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
      String[] entrada;
      int num = Integer.parseInt(reader.nextLine());
      while(num > 0){
        entrada = new String[num];
        for(int i = 0; i < num; i++){
          entrada[i] = new String(reader.nextLine());
        }
        if(goodSet(entrada)){
          writer.write("Conjunto Bom");
          writer.write("\n");
        }
        else {
          writer.write("Conjunto Ruim");
          writer.write("\n");
        }
        num = Integer.parseInt(reader.nextLine());
      }
      reader.close();
      writer.close();
    }
      catch (IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
