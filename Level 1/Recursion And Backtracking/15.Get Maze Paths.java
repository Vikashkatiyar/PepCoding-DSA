import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<String> res=getMazePaths(1,1,n,m);
        System.out.println(res);
    }

    
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        if(sc==dc && sr==dr){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> hpath=new ArrayList<>();
        ArrayList<String> vpath=new ArrayList<>();

        if(sc<dc){
            hpath=getMazePaths(sr,sc+1,dr,dc);
        }
        if(sr<dr){
            vpath=getMazePaths(sr+1,sc,dr,dc);
        }

        ArrayList<String> list=new ArrayList<>();
        for(String s:hpath){
            list.add("h"+s);
        }
         for(String s:vpath){
            list.add("v"+s);
        }
        return list;
        



    }

}
