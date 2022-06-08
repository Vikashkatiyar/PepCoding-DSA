import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

       
        System.out.println(countEncodeTab(str));
    }

   

    public static int countEncodeTab(String str){
        int []dp=new int[str.length()+1];
        dp[str.length()]=1;

        for(int i=str.length()-1;i>=0;i--){
             int ch1=(str.charAt(i)-'0');
            if(ch1>=1 && ch1<=9){
                dp[i]+=dp[i+1];
            }

            if(i+1<str.length()){
                int ch12=(str.charAt(i)-'0')*10+(str.charAt(i+1)-'0');
                if(ch12>=10 && ch12<=26){
                    dp[i]+=dp[i+2];
                }
            }
        }

        return dp[0];
    }
}
