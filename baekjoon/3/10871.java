package JOON;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int arr[] = new int[a] ;

		for(int i=0;i<a;i++){
			arr[i]=scan.nextInt();
		}
		for(int j=0;j<a;j++){
			if(arr[j]<b)
				System.out.print(arr[j]+" ");
		}
	}
}
