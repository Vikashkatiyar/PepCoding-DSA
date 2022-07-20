import java.io.*;

import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();

    long[] dp = new long[n + 1];
    long same = k * 1;
    long diff = k *  (k - 1);
    long total = same + diff;

    for (int i = 3; i <dp.length; i++) {
      same = diff * 1;
      
      diff = total * (k - 1);
      total = same + diff;
    }

    System.out.println(total);
  }
}
