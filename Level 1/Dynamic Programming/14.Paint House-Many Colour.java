import java.io.*;
import java.util.*;

public class Main {
    //TC:O(n2)
    public static void main(String[] args) throws Exception {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int c=sc.nextInt();
      int [][]arr=new int[n][c];

      for(int i=0;i<arr.length;i++){
          for(int j=0;j<arr[0].length;j++){
              arr[i][j]=sc.nextInt();
          }
      }

      int [][]dp=new int[arr.length][arr[0].length];

      int least=Integer.MAX_VALUE;
      int sleast=Integer.MAX_VALUE;
      for(int j=0;j<arr[0].length;j++){
          dp[0][j]=arr[0][j];

          if(arr[0][j]<=least){
            sleast=least;
            least=arr[0][j];
          }else if(arr[0][j]<=sleast){
              sleast=arr[0][j];
          }
      }

      

      for(int i=1;i<dp.length;i++){
          int nleast=Integer.MAX_VALUE;
          int snleast=Integer.MAX_VALUE;
          for(int j=0;j<dp[0].length;j++){
              if(least==dp[i-1][j]){
                  dp[i][j]=sleast+arr[i][j];
              }else{
                  dp[i][j]=least+arr[i][j];
              }


              if(dp[i][j]<=nleast){
                  snleast=nleast;
                  nleast=dp[i][j];
              }else if(dp[i][j]<=snleast){
                  snleast=dp[i][j];
              }

          }
          least=nleast;
          sleast=snleast;
      }

      System.out.println(least);
    }
}
