import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int []arr=new int[n];
    for(int i=0;i<arr.length;i++){
        arr[i]=sc.nextInt();
    }


    HashMap<Integer,Boolean> map= new HashMap<>();

    for(int val:arr){
        map.put(val,true);
    }

    for(int val:arr){
        if(map.containsKey(val-1)){
            map.put(val,false);
        }
    }

    int msp=0;
    int ml=0;
    for(int val : arr){
        if(map.get(val)==true){
            int tlen=1;
            int tsp=val;

            while(map.containsKey(tsp+tlen)){
                tlen++;
            }

            if(tlen>ml){
                msp=tsp;
                ml=tlen;
            }
        }
    }


    for(int i=0;i<ml;i++){
        System.out.println(msp+i);
    }
 }

}
