//item on level
import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci,int n, int k){
    if(ci>k){
      for(int i=0;i<n;i++){
        System.out.print(boxes[i]);
      }
      System.out.println();
      return;
    }

    for(int i=0;i<n;i++){
      if(boxes[i]==0){
        boxes[i]=ci;
        permutations(boxes,ci+1,n,k);
        boxes[i]=0;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1,nboxes, ritems);
  }

}
