//Box on level
//select two distict characters from given string not arrange them 
import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    combination(0, ustr, 0, k, "");
  }


  public static void combination(int startIdx, String unique, int cb, int k, String asf ) {
   if(startIdx==unique.length()){
     if(asf.length()==k){ //cb==k
       System.out.println(asf);
     }
     return;
   }

   char ch=unique.charAt(startIdx);
   combination(startIdx+1,unique,cb+1,k,asf+ch);
   combination(startIdx+1,unique,cb,k,asf+"");
  }

}
