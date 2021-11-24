//////////
//Wayne Mattis
//
//////////
//This class computes the "average letter" of an entered phrase, i.e. the character with a numeric value equivalent to the mean of the numeric values of each letter in the phrase.

import java.util.Scanner;

public class AvLetter{
  public static void main(String[] args){
    int sum=0,num=0,result=0,len=0;    //initialize all necessary variables
    String str="";
    Scanner scn=new Scanner(System.in);
    System.out.println("enter a phrase");
    str=scn.nextLine();                //assigns user input to "str" variable
    len=str.length();
    for (int i=len-1;i>=0;i--){        //"i" used to represent loop index; counts down from the length of the phrase
      char chr=str.charAt(i);          //chr is reassigned a new value for every character in the string
      if (Character.isLetter(chr)){
        chr=Character.toLowerCase(chr);
        sum+=chr;                     //sum is an int, so adding chr to it will automatically cast chr as an int first.
        num+=1;                       //num counts the total number of letters.
      }
    }
      if (len>0){                     //The "if" statement is necessary to prevent a division by zero in the case that the string is empty
        result=sum/num;
      }
    System.out.println("average is: "+(char) result);    //the result must be cast as a char for the desired output.
  }
}