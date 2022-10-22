package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[] =new int[10];
		int max=0,count=0;
		
		for(int i=0;i<9;i++) {
			arr[i]=scan.nextInt();
			
			if(max<arr[i]) {
				max=arr[i];
				count=i+1;
			}
		}
		System.out.println(max);
		System.out.println(count);
	}
}
