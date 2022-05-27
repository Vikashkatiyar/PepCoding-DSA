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

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
                    ArrayList<String> base=new ArrayList<>();
                    base.add("");
                    return base;

        }
      else if (sr > dr || sc > dc)
        {
        ArrayList<String> base = new ArrayList< >();
        return base;
        }


        ArrayList<String> list=new ArrayList<>();
        ArrayList<String> hpath=new ArrayList<>();
        ArrayList<String> vpath=new ArrayList<>();
        ArrayList<String> dpath=new ArrayList<>();
        //horizontal
        for(int h=1;h<=dc-sc;h++){
             hpath=getMazePaths(sr,sc+h,dr,dc);
            for(String s:hpath){
                list.add("h"+h+s);
            }
        }

        //vertical
        for(int v=1;v<=dr-sr;v++){
             vpath=getMazePaths(sr+v,sc,dr,dc);
            for(String s:vpath){
                list.add("v"+v+s);
            }
        }

        //diagonal
        for(int d=1;d<=dc-sc && d<=dr-sr;d++){
           dpath=getMazePaths(sr+d,sc+d,dr,dc);
            for(String s:dpath){
                list.add("d"+d+s);
            }
        }
        return list;
    }

}
