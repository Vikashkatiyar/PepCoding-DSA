import java.io.*;
import java.util.*;

public class Main {
    public static String reverse(String str) {
		StringBuilder ans = new StringBuilder();
		for(int i = str.length() - 1; i >= 0 ; i--) {
			ans.append(str.charAt(i));
		}
		return ans.toString();
	}

	public static void generatepw(int cs, int len, HashMap<Character, Integer> map, Character oddc, String asf) {
		if(cs>len){
			String rev=reverse(asf);
			String res=asf;
			if(oddc!=null){
				res+=oddc;
			}
			res+=rev;

			System.out.println(res);
			return;


		}
		for(char ch:map.keySet()){
			int freq=map.get(ch);
			if(freq>0){
				map.put(ch,freq-1);
				generatepw(cs+1,len,map,oddc,asf+ch);
				map.put(ch,freq);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		//write your code here
		Character oddc=null;
		int oddCount=0;
		int len=0;
		for(Character key:fmap.keySet()){
			int freq=fmap.get(key);
			if(freq%2==1){
				oddc=key;
				oddCount++;
			}
			fmap.put(key,freq/2);
			len+=freq/2;
		}
		if(oddCount>1){
			System.out.println("-1");
			return;
		}
		generatepw(1,len,fmap,oddc,"");
	}
	
}
