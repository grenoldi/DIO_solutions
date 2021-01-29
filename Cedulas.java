import java.util.Scanner;
import java.lang.Math;

public class Cedulas{
  
  public static void printLine(int num, int val){
    System.out.printf("%d nota(s) de R$ %d,00\n", num, val);
  }
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int entrada, num100 = 0, num50 = 0, num20 = 0, num10 = 0, num5 = 0, num2 = 0, num1 = 0;
    
    entrada = Integer.parseInt(sc.nextLine());
    
    num100 = entrada / 100;
    entrada = entrada % 100;
    
    num50 = entrada / 50;
    entrada = entrada % 50;
    
    num20 = entrada / 20;
    entrada = entrada % 20;
    
    num10 = entrada / 10;
    entrada = entrada % 10;
    
    num5 = entrada / 5;
    entrada = entrada % 5;
    
    num2 = entrada / 2;
    entrada = entrada % 2;
    
    num1 = entrada;
    
    printLine(num100, 100);
    printLine(num50, 50);
    printLine(num20, 20);
    printLine(num10, 10);
    printLine(num5, 5);
    printLine(num2, 2);
    printLine(num1, 1);
  }
}