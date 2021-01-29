import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


class GFG{
    
  public static String eraseEcho(String texto, int index) {
      String saida = new String(texto);
      if(index == 0) return saida;
      else{
        saida = new String(texto.substring(0, index));
      }
      return saida;
  }
  
  public static int findEcho(String str) { 
    int len = str.length();
    int first_pos = len-1; 
    int compare_first = first_pos-1;
    int size = len-first_pos;
    int target_pos = 0;
    String endsubstr, sectolastsubstr;
    while(size <= len/2){
      endsubstr = new String(str.substring(first_pos,len));
      sectolastsubstr = new String(str.substring(compare_first, first_pos));
      System.out.printf("%s %s\n", endsubstr, sectolastsubstr);
      if(endsubstr.equals(sectolastsubstr)){
        System.out.println("oi");
        target_pos = first_pos;
      }
      System.out.println(target_pos);
      first_pos--;
      size = len - first_pos;
      compare_first = first_pos - size;
    }
    
    return target_pos;
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
    
      //insert code below
      String linha;
      int index;
      while(reader.hasNextLine()){
        linha = reader.nextLine();
        index = findEcho(linha);
        linha = new String(eraseEcho(linha, index));

        writer.write(linha);
        writer.write("\n");
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