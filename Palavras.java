import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {  
      if (o1.length() < o2.length()) {
         return 1;
      } else if (o1.length() > o2.length()) {
         return -1;
      }
      return o1.compareTo(o2);
    }
}

public class Palavras {
  
  public static String stringficator(ArrayList<String> entrada){
    String saida = "";
    int num = entrada.size();
    for (int i = 0; i < num; i++){
      if (i < num -1)
        saida += entrada.get(i) + " ";
      else 
        saida += entrada.get(i) + "\n";
    }
    return saida;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] entrada;
    ArrayList<String> palavras;
    int size, num = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < num; i++){
      entrada = sc.nextLine().split(" ");
      size = entrada.length;
      palavras = new ArrayList<String>();
      for (int j = 0; j < size; j++){
        palavras.add(entrada[j]);
      }
      Collections.sort(palavras, new MyComparator());
      System.out.print(stringficator(palavras));
    }
  }
}