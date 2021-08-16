package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String asc = scan.next();
		int arr[]= new int[26];
		int count=0;
		

		
		for(int i=1;i<asc.length();i++) {
			if(arr[asc.charAt(i)-'a']==0 && asc.charAt(i)-'a' != asc.charAt(0)-'a' )
				arr[asc.charAt(i)-'a']=i;
		}
		for(int i=0; i<26;i++) {
			if(arr[i] == 0 && i != asc.charAt(0)-'a') {
				arr[i]=-1;
			}
			System.out.print(arr[i]+" ");
		}
	}	
}
