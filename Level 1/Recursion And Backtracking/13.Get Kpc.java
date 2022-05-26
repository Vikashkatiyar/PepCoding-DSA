import java.io.*;
import java.util.*;

public class Main {
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        ArrayList<String> res=getKPC(str);
        System.out.println(res);

    }
    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }

        char ch=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> list=getKPC(ros);
        ArrayList<String> mlist=new ArrayList<>();
        String codeforch = codes[ch - '0'];                          
    
        for(int i=0;i<codeforch.length();i++){
            char chr=codeforch.charAt(i);
            for(String s:list){
                mlist.add(chr+s);
            }
        }
        return mlist;
    }

}
