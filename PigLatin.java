//////////
//Wayne Mattis
//
//////////

import java.util.StringTokenizer;

public class PigLatin{
  //This class takes user input and translates into Pig Latin--this means adding "-ay" to the end of a word and bringing the first letter, if it is a consonant, to the end of the original word (before the "-ay") 
 public String str;
 StringTokenizer tok;
 char[] charList;
 
 public PigLatin(String instr){//constructor statement for the PigLatin class
   formatted(instr);
 }
 
 public void formatted(String instr){//removes all punctuation and sets string to lowercase format
   instr=instr.toLowerCase();
   instr=instr.trim();
   String dummy="";
   charList=instr.toCharArray();
   for (int i=0;i<charList.length;i++){
     if (charList[i]!=32 && (charList[i]<97 || charList[i]>122) && charList[i]!=10){
       dummy+=charList[i];
       str.replace(dummy,"");
     }
   }
   for (char ch : charList){this.str+=ch;}
 }
 
 public String tokenConversion(String s){//translates one word into Pig Latin
   char[] chl=s.toCharArray();
   switch(chl[0]){
     case 'a':case 'e': case 'i': case 'o': case 'u': return s+"ay";
     default: 
       chl.add(chl[0]);
       chl[0].remove();
       return s+"ay";
   }
 }
   
   
 public void pigAll(){//translates user input into Pig Latin
   tok=new StringTokenizer(str);
   str="";
   while (tok.hasMoreTokens()){
     str+=tokenConversion(tok.nextToken);
   }
 }
 
 public void pigReport(){
   System.out.print(str);
 }
   
 }