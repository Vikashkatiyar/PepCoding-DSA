import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        int []dp=new int[str.length()];
        Arrays.fill(dp,-1);

        System.out.println(countEncode(str,0,dp));
    }

    public static int countEncode(String str,int idx,int[] dp){
        if(idx==str.length()){
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int ans=0;
        int ch1=(str.charAt(idx)-'0');
        if(ch1>=1 && ch1<=9){
            ans+=countEncode(str,idx+1,dp);
        }

        if(idx+1<str.length()){
            int ch12=(str.charAt(idx)-'0')*10+(str.charAt(idx+1)-'0');
            if(ch12>=10 && ch12<=26){
                ans+=countEncode(str,idx+2,dp);
            }
        }

        dp[idx]=ans;
        return ans;
    }
}
