package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a= scan.nextInt();
		int count=0;

		for(int i=1;i<=a;i++) {
			int m1=((i/10)%10)-(i%10);
			int m2=(i/100)-((i/10)%10);
			if(i>0 && i<100)
				count++;
			else if(m1 == m2 ) 
				count++;
		}
		System.out.println(count);
		
	}	
}
