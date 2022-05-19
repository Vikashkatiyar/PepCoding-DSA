import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner sc=new Scanner(System.in);
       int x=sc.nextInt();
       int n=sc.nextInt();
       System.out.println(power(x,n));
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
       // if(n==1){
        //    return x;
        // }   
        int pow1=power(x,n/2);
        int pow2=power(x,n/2);
        int pow=pow1*pow2;
        if(n%2!=0){
            pow=x*pow;
        }
        return pow;
    }

}
