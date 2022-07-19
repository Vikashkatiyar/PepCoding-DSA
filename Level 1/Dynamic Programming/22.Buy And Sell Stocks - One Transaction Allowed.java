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

        int minDay=cost[0];
        int maxProfit=0;

        for(int i=1;i<n;i++){
            int currProfit=cost[i]-minDay;

            if(currProfit>maxProfit){
                maxProfit=currProfit;
            }


            if(cost[i]<minDay){
                minDay=cost[i];
            }
        }

        System.out.println(maxProfit);
    }

}
