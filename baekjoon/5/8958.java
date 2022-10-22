package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a=scan.nextInt();	
		char arr[] =new char[80];

		

		
		for(int i=0;i<a;i++) {
			int point=0,sum=0;
			arr=scan.next().toCharArray();
			for(int j=0;j<arr.length;j++) {
				if(arr[j]=='O') {
					point++;
					sum += point;
				}else if(arr[j]=='X') {
					point=0;
				}
			}
			System.out.println(sum);
		}
	}
}
