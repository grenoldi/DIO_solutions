import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


class Num{
  private int val;
  private int num;
  
  public Num(int v){
    this.setVal(v);
    this.setNum(1);
  }
  
  public void setVal(int v){
    this.val = v;
  }
  
  public void setNum(int n){
    this.num = n;
  }
  
  public int getVal(){
    return this.val;
  }
  
  public int getNum(){
    return this.num;
  }
  
  public void increase(){
    this.num++;
  }
  
  @Override
  public String toString(){
    return String.format("%d aparece %d vez(es)", this.val, this.num);
  }
}


class valueSorter implements Comparator<Num> {
    @Override
    public int compare(Num n1, Num n2) {
        if(n1.getVal() > n2.getVal()) return 1;
        return -1;
    }
}

public class Contagem {
  ArrayList<Num> valores;
  
  public Contagem(){
    valores = new ArrayList<Num>();
  }
  
  public void printValores(FileWriter fw) throws IOException{
    int length = valores.size();
    for (int i = 0; i < length; i++){
      fw.write(valores.get(i).toString());
      fw.write("\n");
    }
  }
  
  public boolean addNum(int n){
    int length = valores.size();
    System.out.printf("valor do n a ser adicionado: %d\n", n);
    System.out.printf("valor do tamanho do vetor: %d\n", length);
    if(length == 0) {
      System.out.println("Caso zero");
      valores.add(new Num(n));
      return true;
    }
    else{
      for (int i = 0; i < length; i++){
        System.out.printf("valor no arraylist em %d: %d\n", i, valores.get(i).getVal());
        if (valores.get(i).getVal() == n){
          System.out.println("Ja existe");
          valores.get(i).increase();
          return true;
        }
      }
      System.out.println("nao existe");
      valores.add(new Num(n));
      return true;
    }
  }
  
  public void sortValores(){
    Collections.sort(valores, new valueSorter());
  }
  
  public static void main(String[] args) {
    String filename = "";
    try{
      if(args.length > 0){
        filename = new String(args[0]);
        System.out.println("Using input file " + filename);
      }
      Scanner sc = new Scanner(new File(filename));
      FileWriter writer = new FileWriter(new File("saida_"+filename));
    
      Contagem cont = new Contagem();
    
      int num = Integer.parseInt(sc.nextLine());
    
      for(int i = 0; i < num; i++){
        cont.addNum(Integer.parseInt(sc.nextLine()));
      }
    
      cont.sortValores();
    
      cont.printValores(writer);
      sc.close();
      writer.close();
    }
      catch (IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}