import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;


class Calculadora{
  public static void main(String[] args) {
    String filename = "";
    try{
      if(args.length > 0){
        filename = new String(args[0]);
        System.out.println("Using input file " + filename);
      }
      Scanner reader = new Scanner(new File(filename));
      FileWriter writer = new FileWriter(new File("saida.txt"));
      
      // insert code below
      String[] entrada;
      int num = Integer.parseInt(reader.nextLine());
      BigDecimal res = new BigDecimal("1");
      BigDecimal val;
      for (int i = 0; i < num; i++){
        entrada = reader.nextLine().split(" ");
        val = new BigDecimal(entrada[0]);
        if(val.compareTo(new BigDecimal("9")) == 1) continue;
        if(entrada[1].equals("/") && val.compareTo(new BigDecimal("0"))!=0) res = res.divide(val, MathContext.DECIMAL128);
        else if(entrada[1].equals("*")) res = res.multiply(val);
      }
      writer.write(String.format("%.0f\n", res.setScale(0, RoundingMode.DOWN)));
      
      reader.close();
      writer.close();
    }
      catch (IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
