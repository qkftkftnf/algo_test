package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int i,j,k;

		for( i=a;i>0;i--){
			for(j=0;j<i-1;j++) {
				System.out.print(" ");
			}
			for(k=0;k<a-j;k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
