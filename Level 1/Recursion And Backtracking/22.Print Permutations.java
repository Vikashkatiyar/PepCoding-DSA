import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        printPermutations(str,"");
    }

    public static void printPermutations(String que, String asf) {
        if(que.length()==0){
            System.out.println(asf);
            return;
        }
        
        for(int i=0;i<que.length();i++){
        char ch=que.charAt(i);
        String lp=que.substring(0,i);
        String rp=que.substring(i+1);
        String roq=lp+rp;
        printPermutations(roq,asf+ch);
        }
    }

}
