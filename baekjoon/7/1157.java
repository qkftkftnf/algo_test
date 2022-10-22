package JOON;

import java.util.*;



public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String asc = scan.next();
		char a[]=new char[1000001];
		int arr[]= new int[26];
		int count=0;
		int samecount=0;
		int mc=0;
		
		

		
		for(int i=0;i<asc.length();i++) {
			if(asc.charAt(i)>='A' && asc.charAt(i)<='Z') {
				a[i]=(char)(asc.charAt(i)+32);
			}
			else
				a[i]=(asc.charAt(i));
			
			arr[a[i]-'a']+=1;	
			
		}
		
		for(int i=0; i<26;i++) {
			if(arr[i] >count) {
				count=arr[i];
				mc=i;
			}
			else if( count==arr[i]) {
				samecount=arr[i];

			}
		}
		
		if(count==samecount) {
			System.out.println("?");
		}else {
			char max=(char) (mc+'A');
			System.out.println(max);
		}				
	}
}
