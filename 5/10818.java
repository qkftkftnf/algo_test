package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int arr[] =new int[a];
		int min=0,max=0;
		
		for(int i=0;i<a;i++) {
			arr[i]=scan.nextInt();
			if(i==0) {
				min=max=arr[i];
			}
			else if(min>arr[i]) {
				min=arr[i];
			}
			else if(max<arr[i]) {
				max=arr[i];
			}
		}
		System.out.print(min + " " + max);
	}
}
