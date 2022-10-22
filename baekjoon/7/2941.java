package JOON;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		int count=0;

		for(int i=0;i<a.length();i++) {
			count++;
			if(i>0) {
			if(i>1 && a.charAt(i)=='=' &&  a.charAt(i-1)=='z' &&  a.charAt(i-2)=='d')
				count-=2;
			else if(a.charAt(i)=='=' &&(a.charAt(i-1)=='c' || a.charAt(i-1)=='s' || a.charAt(i-1)=='z'))
				count--;
			else if(a.charAt(i)=='-' && (a.charAt(i-1)=='d' ||  a.charAt(i-1)=='c'))
				count--;
			else if(a.charAt(i)=='j' && ( a.charAt(i-1)=='l' ||  a.charAt(i-1)=='n'))
				count--;
			}
				
				
		}
		System.out.println(count);
	}
}
