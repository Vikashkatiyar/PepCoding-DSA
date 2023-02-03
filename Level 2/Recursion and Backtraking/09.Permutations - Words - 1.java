//BOX on level
import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cb, int ts, HashMap<Character, Integer> map, String asf) {
      if(cb>ts){
        if(asf.length()==ts){
          System.out.println(asf);
        }
        return;
      }

      for(Character key:map.keySet()){
        int val=map.get(key);
        if(val>0){
          map.put(key,val-1);
          generateWords(cb+1,ts,map,asf+key);
          map.put(key,val);
        }
      }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    HashMap<Character, Integer> fmap = new HashMap<>();
    for(char ch: str.toCharArray()){
      if(fmap.containsKey(ch)){
        fmap.put(ch, fmap.get(ch) + 1);
      } else {
        fmap.put(ch, 1);
      }
    }

    generateWords(1, str.length(), fmap, "");
  }

}
