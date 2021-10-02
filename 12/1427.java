//배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
import java.util.*;


public class Main {
	 
	 public static void main(String[] args) {	
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int length=(int)(Math.log10(a)+1);
		int arr[]=new int[length];
		
		for(int i=0;i<length;i++) {
			arr[i]=a%10;
			a=a/10;
		
		}
		
		Arrays.sort(arr);
		
		for(int i=length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
		
		
	}		 
}
	 
	
