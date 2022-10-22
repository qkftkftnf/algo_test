package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		double arr[] =new double[10000];
		double max=0,sum=0;
		

		
		for(int i=0;i<a;i++) {
			arr[i]=scan.nextDouble();
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		
		for(int j=0;j<a;j++) {
			arr[j]=arr[j]/max*100;
			sum+=arr[j];
		}
		
		System.out.println(sum/a);
	}
}
