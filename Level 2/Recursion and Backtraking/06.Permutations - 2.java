//Box on level(combination to permutaion

import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int cb, int n, boolean[] items, int itemPlaced, int k, String asf){
    if(cb>n){
      if(itemPlaced==k){
        System.out.println(asf);
      }
      return;
    }
    for(int i=0;i<k;i++){
      if(items[i]==false){
        items[i]=true;
        permutations(cb+1,n,items,itemPlaced+1,k,asf+(i+1));
        items[i]=false;
      }
    }
    permutations(cb+1,n,items,itemPlaced,k,asf+0);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new boolean[ritems], 0, ritems, "");
  }

}
