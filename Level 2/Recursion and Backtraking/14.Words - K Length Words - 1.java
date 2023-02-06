import java.io.*;
import java.util.*;

public class Main {
  public static void generateWord(String unique,int startIdx,int k,int currSel,Character[] spots) {
    //Base Case
    if(startIdx==unique.length()){
      if(currSel==k){
        for(int i=0;i<spots.length;i++){
          System.out.print(spots[i]);
        }
        System.out.println();
      }
      return;
    }

    char ch=unique.charAt(startIdx);
    //Yes
    for(int i=0;i<spots.length;i++){
      if(spots[i]==null){
        spots[i]=ch;
        generateWord(unique,startIdx+1,k,currSel+1,spots);
        spots[i]=null;
      }
    }

    //No
    generateWord(unique,startIdx+1,k,currSel,spots);
  }
 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    Character[] spots=new Character[k];
    generateWord(ustr,0,k,0,spots);
  }

}
