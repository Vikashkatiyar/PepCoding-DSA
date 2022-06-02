import java.io.*;
import java.util.*;

public class Main {


    public static boolean targetSumSetRecursion(int[] arr,int idx,int sum,int target){
        if(idx==arr.length){
            if(target==sum){
                return true;
            }
            else{
                return false;
            }
        }

        //include karna h
        boolean yes=targetSumSetRecursion(arr,idx+1,sum+arr[idx],target);

        //include nahi karna 
        boolean no=targetSumSetRecursion(arr,idx+1,sum,target);
        if(yes==true || no==true)
          return true;
        return false;

    }

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();

        // recursion
        System.out.println(targetSumSetRecursion(arr,0,0,target));
 
    }
 
}
