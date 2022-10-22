package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
				
		int arr[] =new int[10];
		int count=10;
		

		
		for(int i=0;i<10;i++) {
			int a=scan.nextInt();
			a %= 42;
			arr[i]=a;
		}
		
		for(int j=0;j<10;j++) {
			for(int k=j+1;k<10;k++) {
				if(arr[j]==arr[k]) {
					count--;
					break;
				}
			}		
		}
		System.out.println(count);
	}
}
