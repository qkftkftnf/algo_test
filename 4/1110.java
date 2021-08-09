package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b=a,c;
		int count = 0;
		
		
		do {
			c=(b/10)+(b%10);
			
			if(c>=10) {
				c  %= 10;
			}
			b=(b%10)*10+c;

			count++;
		}while(b!=a);
		System.out.println(count);
	}
}
