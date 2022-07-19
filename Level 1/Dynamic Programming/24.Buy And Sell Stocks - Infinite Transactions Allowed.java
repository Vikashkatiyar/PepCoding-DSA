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


        int buy=0;
        int sell=0;
        int profit=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                sell++;
            }else{
                profit+=arr[sell]-arr[buy];
                buy=sell=i;
            }
        }
         profit+=arr[sell]-arr[buy];
         System.out.println(profit);

    }

}
