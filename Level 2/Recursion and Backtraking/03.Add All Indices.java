import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        ArrayList<Integer> list=new ArrayList<>();
        allIndices(arr,x,0,list);
        
        if(list.size()==0){
            System.out.println();
            return;
        }
        
        for(int i:list){
            System.out.println(i);
        }
    }

    public static void allIndices(int[] arr, int x, int idx,ArrayList<Integer> list) {
        if(idx==arr.length){
            return;
        }
        
        if(arr[idx]==x){
            list.add(idx);
        }
        allIndices(arr,x,idx+1,list);
    }

}
