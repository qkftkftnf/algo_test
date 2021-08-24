package JOON;

import java.util.*;

public class Main {
	public static int sum(int x,int y) {
		int sum=0;
		if(x-1==0) {
			for(int i=1;i<=y;i++) {
				sum+=i;
			}
		}
		else if(y==1)
			sum=1;
		else {
			sum=sum(x-1, y)+sum(x, y-1);
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		
		for(int i=0;i<a;i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			System.out.println(sum(x,y));
			
			
		}
	}
}
