//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
import java.util.*;

public class Main {
	 static void swap(int[] array,int i, int j) {

		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
		
	}
		
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();

		int arr[]=new int[1001];
	
		
		for(int i=0;i<a;i++) {
			arr[i]=scan.nextInt();
		}
		
		for(int i=0;i<a;i++) {
			int seat=i;
			for(int j=i+1;j<a;j++) {
				if(arr[j]<arr[seat])
					seat=j;
			}
			swap(arr,i,seat);
			System.out.println(arr[i]);
		}
		
		
	}

	
}