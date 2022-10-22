package JOON;

import java.util.*;

public class Main {
	
	public static int reverse(int a) {
		int Ra=(a/100)+((a%100)/10)*10+((a%100)%10)*100;
		return Ra;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();

		
			
		System.out.print((reverse(a)>reverse(b))?reverse(a):reverse(b));	
		}
}
