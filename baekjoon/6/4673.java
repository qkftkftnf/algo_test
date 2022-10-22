package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int a=0;
		int arr[] =new int[10001];


		for(int i=0;i<10000;i++) {
			a=i+(i%10)+((i/10)%10)+(i/100%10)+(i/1000);
			if(a<10001)
				arr[a]=1;
		}
		for(int i=0;i<arr.length;i++) {	
			if(arr[i]!=1) {
				System.out.println(i);
			}
		}
	}	
}
