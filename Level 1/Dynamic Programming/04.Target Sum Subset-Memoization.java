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
        int target=sc.nextInt();

        

        // Memoization
        int [][]dp=new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        System.out.println(targetSumSetMemoization(arr,0,0,target,dp));

    }

    public static boolean targetSumSetMemoization(int[] arr,int idx,int sum,int target,int [][]dp){
        if(idx==arr.length){
            if(target==sum){
                return true;
            }
            else{
                return false;
            }
        }
        if(sum > target) return false;
        if(dp[idx][sum]!=-1){
            if(dp[idx][sum]==1){
                return true;
            }else{
                return false;
            }
        }

        //include karna h
        boolean yes=targetSumSetMemoization(arr,idx+1,sum+arr[idx],target,dp);

        //include nahi karna 
        boolean no=targetSumSetMemoization(arr,idx+1,sum,target,dp);


        if(yes==true || no==true)
          {
              dp[idx][sum]=1;
              return true;
          }
          else{
              dp[idx][sum]=0;
              return false;
          }

    }

    
}
