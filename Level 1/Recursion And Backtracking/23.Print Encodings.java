import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        printEncodings(input,"");
    }

    public static void printEncodings(String input,String output) {
        if(input.length()==0){
            System.out.println(output);
            return;
        }

        char ch1=input.charAt(0);
        if(ch1>='1' && ch1<='9'){
            printEncodings(input.substring(1),output+(char)(ch1-'0'+'a'-1));
        }

        if(input.length()>1){
            String ch12=input.substring(0,2);
            int ch12Int=Integer.parseInt(ch12);
            if(ch12Int>=10 && ch12Int<=26){
                printEncodings(input.substring(2),output+(char)(ch12Int+'a'-1));
            }
        }
        
    }

}
