package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		String asc = scan.next();
		int count=0;

		
		for(int i=0;i<a;i++) {
			count +=  asc.charAt(i)-'0';
		}
		
		System.out.println(count);
		
	}	
}
