import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        int fee=sc.nextInt();

        int obsp=-arr[0];
        int ossp=0;

        for(int i=1;i<arr.length;i++){
           int nbsp=0;
           int nssp=0;
//for bsp range
           if(ossp-arr[i]>obsp){
               nbsp=ossp-arr[i];
           }else{
               nbsp=obsp;
           }

//for ssp range
           if(obsp+arr[i]-fee>ossp){
               nssp=obsp+arr[i]-fee;
           }else{
               nssp=ossp;
           }

           obsp=nbsp;
           ossp=nssp;
        }
        System.out.println(ossp);
    }

}
