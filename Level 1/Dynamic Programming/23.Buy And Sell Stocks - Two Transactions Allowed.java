import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []cost=new int[n];
        for(int i=0;i<n;i++){
            cost[i]=sc.nextInt();
        }

        int []left=new int[n];
        int []right=new int[n];

//Aaj yaa aaj se pahle bechaa ho
        int buyingDay=cost[0];
        for(int i=1;i<n;i++){
            int currProfit=cost[i]-buyingDay;
            currProfit=Math.max(currProfit,left[i-1]);
            left[i]=currProfit;
            buyingDay=Math.min(buyingDay,cost[i]);
        }


//Aaj yaa aaj se pahle kharida hoo
        int sellingDay=cost[n-1];
        for(int i=n-2;i>0;i--){
            int currProfit=sellingDay-cost[i];
            currProfit=Math.max(currProfit,right[i+1]);
            right[i]=currProfit;

            sellingDay=Math.max(sellingDay,cost[i]);
        }


        int maxProfit=0;
        for(int i=0;i<n;i++){
            maxProfit=Math.max(maxProfit,left[i]+right[i]);
        }
        System.out.println(maxProfit);
    }

}
