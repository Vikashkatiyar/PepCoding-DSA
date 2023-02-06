//item on level
//select two distict charcters from given String 
import java.io.*;
import java.util.*;

public class Main {
  public static void generateSel(String unique,int currsel,int k,int lastIdx,String asf){
    if(asf.length()==k){  //currSel>k
      System.out.println(asf);
      return;
    }


    for(int i=lastIdx+1;i<unique.length();i++){
      char ch=unique.charAt(i);
      generateSel(unique,currsel+1,k,i,asf+ch);
    }
  }

  public static void main(String[] args){
     Scanner sc=new Scanner(System.in);
     String s=sc.next();
     int k=sc.nextInt();

     HashSet<Character> set=new HashSet<>();
     String unique="";
     for(Character ch:s.toCharArray()){
       if(set.contains(ch)==false){
         set.add(ch);
         unique+=ch;
       }
     }

     generateSel(unique,1,k,-1,"");
  }

}
