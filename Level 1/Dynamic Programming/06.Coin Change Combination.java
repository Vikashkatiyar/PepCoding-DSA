import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        int tar=sc.nextInt();

        int []dp=new int[tar+1];
        dp[0]=1;
        for(int coin:arr){
            for(int i=1;i<=tar;i++){
                if(coin<=i){
                    dp[i]+=dp[i-coin];
                }
            }
        }
        System.out.println(dp[tar]);
    }
}
