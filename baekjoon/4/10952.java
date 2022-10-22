package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int b=1,c=1;

		while(true) {
			b = scan.nextInt();
			c = scan.nextInt();
			int sum=b+c;
			
			if(b==0 && c==0) {
				break;
			}
			else {
				System.out.println(sum);
			}		
		}
	}
}
