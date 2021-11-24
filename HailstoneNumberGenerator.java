////////
//Wayne Mattis
//
////////


import java.util.Scanner;

public class Hail{  //This program generates "Hailstone numbers" which rise and fall but, subject to the algorithm, are fated to eventually reach 1.
  public static void main(String[] args){
    int num0,count=1,biggest;   //initialize "count" as 1 because the original input term is to be counted later
    Scanner scn=new Scanner(System.in);
    System.out.println("Enter a positive hailstone starting value");
    num0=scn.nextInt();  //"num0" given its own variable name so the original value can be reported later
    biggest=num0;  //"biggest" set to "num0" as at this point num0 is the biggest term in the sequence
    System.out.println();  //blank line for aesthetic purposes    
    System.out.println(num0);
    for (int num=num0;num!=1;){  //"num" used as the "hailstone;" the loop stops when num=1.
      if (num%2 == 0){  //in the case of num being even, divide it by two
        num/=2;
      }
      else{  //in the case of num being odd, triple num and add 1
        num=3*num+1;
      }
      System.out.println(num);
      count+=1;  //keeps track of how many terms have been assigned to "num"
      if (biggest<num){  //makes sure that the biggest term is assigned to "biggest."  If biggest==num, there is no need to re-assign the same value
        biggest=num;
      }
    }
    System.out.println("start: "+num0);
    System.out.println("term count: "+count);
    System.out.println("biggest: "+biggest);
  }
}