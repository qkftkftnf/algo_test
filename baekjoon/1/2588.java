package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c,d,e,f;
		
		c = a * (b % 10);
		d = a * (((b % 100) - (b % 10))/10);
		e = a * (((b - (b % 100)) / 100));
		f = c + (10 * d) + (100 * e);
		
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);		
	}
}
