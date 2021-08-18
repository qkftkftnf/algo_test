package JOON;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		int count=0;

		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)<'A'+15) {
				count += (((a.charAt(i)-'A') / 3) +3);
			}
			
			else if('A'+14 < a.charAt(i) &&'A'+19 > a.charAt(i)) {
				count += 8;
			}
			else if('A'+21 < a.charAt(i) &&'A'+26 > a.charAt(i)) {
				count += 10;
			}
			else 
				count+=9;
		}
		System.out.println(count);
	
	}
}
