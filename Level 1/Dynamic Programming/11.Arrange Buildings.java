import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();

    long prevB=1l;
    long prevS=1l;

    for(int i=2;i<=n;i++){
        long currB=prevS;
        long currS=prevS+prevB;

        prevB=currB;
        prevS=currS;
    }

    System.out.println((prevB+prevS)*(prevB+prevS));

 }

}
