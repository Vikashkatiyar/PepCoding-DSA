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

       int ans=countPathstab(arr);
       System.out.println(ans);
    }

    public static int countPathstab(int []arr){
        int n=arr.length;
        int[] dp=new int[n+1];
        dp[n]=1;

        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=arr[i] && i+j<dp.length;j++){
                dp[i]+=dp[i+j];
            }
        }
        return dp[0];
    }

}
