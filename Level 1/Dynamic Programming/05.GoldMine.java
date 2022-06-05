import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]arr=new int[n][m];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
         
         //memoization
        //  int [][]dp=new int[n][m];
        //  for(int i=0;i<arr.length;i++){
        //      Arrays.fill(dp[i],-1);
        //  }

        //  int ans=0;
        //  for(int i=0;i<arr.length;i++){
        //      int localAns=maxGold(i,0,arr,dp);
        //      ans=Math.max(ans,localAns);
             
        //  }

        //  System.out.println(ans);


        //Tabulation->
        System.out.println(maxGoldTab(arr));





    }

    public static int maxGold(int r,int c,int[][]arr,int [][]dp){
        if(r<0 || r>=arr.length){
            return 0;
        }

        if(c==arr[0].length-1){
            return arr[r][c];
        }

        if(dp[r][c]!=-1){
            return dp[r][c];
        }

        int up=maxGold(r-1,c+1,arr,dp);
        int right=maxGold(r,c+1,arr,dp);
        int down=maxGold(r+1,c+1,arr,dp);

        int ans= arr[r][c]+Math.max(up,Math.max(down,right));
        dp[r][c]=ans;
        return ans;
    }

    public static int maxGoldTab(int[][] arr){
        int n = arr.length, m = arr[0].length;
        int[][] dp = new int[n][m];
        
        for(int j=m-1; j>=0; j--)
        {
            for(int i=0; i<n; i++)
            {
                if(j == m-1) { 
                    dp[i][j] = arr[i][j];
                } else {
                    int up = (i - 1 >= 0) ? dp[i - 1][j + 1] : 0;
                    int right = dp[i][j + 1];
                    int down = (i + 1 < n) ? dp[i + 1][j + 1] : 0;
                    dp[i][j] = arr[i][j] + Math.max(up, Math.max(right, down));
                }
            }
        }
        
        int ans = 0;
        for(int i=0; i<n; i++)
            ans = Math.max(ans, dp[i][0]);
        
        return ans;
    }


}
