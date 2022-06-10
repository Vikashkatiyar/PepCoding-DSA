// This problem is nothing but Tribonacci Series on leet code
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        // int ans=countPathsRecursion(n);
        // System.out.println(ans);

        // int []dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // int ans=countPathsMemo(n,dp);
        // System.out.println(ans);


        System.out.println(countPathsTab(n));

    }
    public static int countPathsRecursion(int n){
        if(n==0){
            return 1;
        }
        else if(n<0){
            return 0;
        }

        int nm1=countPathsRecursion(n-1);
        int nm2=countPathsRecursion(n-2);
        int nm3=countPathsRecursion(n-3);

        int nm=nm1+nm2+nm3;
        return nm;
    }

    public static int countPathsMemo(int n,int []dp){
        if(n==0){
            return 1;
        }
        else if(n<0){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int nm1=countPathsMemo(n-1,dp);
        int nm2=countPathsMemo(n-2,dp);
        int nm3=countPathsMemo(n-3,dp);

        int nm=nm1+nm2+nm3;
        dp[n]=nm;
        return nm;
    }


    public static int countPathsTab(int n){
        int []dp=new int[n+1];
        dp[0]=1;

        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1];
            }
            else if(i==2){
                dp[i]=dp[i-1]+dp[i-2];
            }
            else{
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
    }
}
