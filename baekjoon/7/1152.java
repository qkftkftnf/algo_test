package JOON;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String asc = scan.nextLine();
		int count=1;

				
		for(int i=1;i<asc.length()-1;i++) {
			
			if (asc.charAt(i) == ' ') {
				count++;
			}
		}
		System.out.print(asc.length() == 1 && asc.charAt(0) == ' ' || asc.length() == 0 ? 0 : count);
	}
}
