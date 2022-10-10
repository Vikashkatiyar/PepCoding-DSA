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

/* without using of HashMap we solve it 
// this is a better approach for this problem in 0(1) space
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0||nums.length==1)
        return nums.length;

        Arrays.sort(nums);

        int max=Integer.MIN_VALUE,c=1;

        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]==1) c++;
            else c=nums[i+1]==nums[i]?c:1;
            if(c>max) max=c;
        }

        return max<0?0:max;
    }
} */
