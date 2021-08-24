package JOON;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		
		for(int i=0;i<a;i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int z = scan.nextInt();
			
			int floor=0;
			int ho=0;
			
			if(z%x==0) {
				floor=x;
				ho=(z/x);
			}
				
			else {
				floor=(z%x);
				ho=(z/x)+1;
			}
			
			if(ho<10)
				System.out.println(floor+"0"+ho);
			else
				System.out.println(floor+""+ho);
		}
	}
}
