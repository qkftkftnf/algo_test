package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a=scan.nextInt();	
		double arr[] =new double[1000];

		for(int i=0;i<a;i++) {
			double sum=0;
			double avg=0;
			double per=0;

			
			int b = scan.nextInt();
			for(int j=0;j<b;j++) {
				arr[j]=scan.nextDouble();
				sum+=arr[j];
			}
			avg=sum/b;
			
			
			for(int k=0;k<b;k++) {
				if(arr[k]>avg) {
					per++;
				}
			}
			
			per=per/b*100;
			String s= String.format("%.3f", per);
			System.out.println(s+"%");
		}
	}
}
