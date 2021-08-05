package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		
		if(b==45) {
			b=0;
			System.out.println(a+" "+b);
		}
		else if(a==0 && b<45){
			a=23;
			b+=15;
			System.out.println(a+" "+b);
		}	
		else if(b>45) {
			b-=45;
			System.out.println(a+" "+b);	
		}	
		else {
			a-=1;
			b+=15;
			System.out.println(a+" "+b);
		}
	}
}
