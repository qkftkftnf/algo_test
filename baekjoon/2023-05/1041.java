import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//주사위
public class Main {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int arr[]=new int[6];
		int one=Integer.MAX_VALUE;
		int two=Integer.MAX_VALUE;
		int three=Integer.MAX_VALUE;
		int max=0;
		long result=0;
		
		for(int i=0;i<6;i++) {
			arr[i]=sc.nextInt();
			one=Math.min(arr[i], one);
			result+=arr[i];
			max=Math.max(max, arr[i]);
		}
		if(n==1) {
			System.out.print(result-max);
		}else {
			
			for(int i=0;i<6;i++) {
				for(int j=0;j<6;j++) {
					if(i+j==5 || i==j)continue;
					two=Math.min(arr[i]+arr[j], two);
				}
			}
			int num=Math.min(arr[0],arr[5]);
			
			for(int i=1;i<5;i++) {
				for(int j=1;j<5;j++) {
					if(i+j==5 || i==j)continue;
					three=Math.min(num+arr[i]+arr[j], three);
				}
			}
			
			result=(three*4)+(4+(n-2)*8)*two+((long)Math.pow(n-2, 2)*5+(n-2)*4)*one;
			
			
			System.out.print(result);
		}	
	}
}
