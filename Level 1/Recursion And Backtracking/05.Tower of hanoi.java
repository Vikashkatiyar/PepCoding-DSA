import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        toh(n,A,B,C);
    }

    public static void toh(int n, int A, int B, int C){
        if(n==0){
            return;
        }
        toh(n-1,A,C,B);
        System.out.println(n+"["+A+" -> "+B+"]");
        toh(n-1,C,B,A);
    }

}
