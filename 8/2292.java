package JOON;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int count=1;
		int cro=1;
		
		if(a==1) {
			System.out.println(count);
		}
		else {
			while(true) {
				if((6*cro)+1>=a)
					break;
				else {
					count++;
					cro+=count;
				}
			}
			System.out.println(count+1);
		}
		
	}
}
