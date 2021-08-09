package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		int arr[] =new int[10];
		int count[] = new int[10];
		
		int mul = a*b*c;

		
		while(mul!=0) {
			int i=0;
			arr[i]=mul%10;
			
			mul /= 10;
			count[arr[i]]++;
			
			i++;
		}
		
		for(int k=0;k<10;k++) {
			System.out.println(count[k]);
		}		
	}
}
