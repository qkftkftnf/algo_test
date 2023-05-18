import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int arr[][]=new int[n][2];
		int dp[]=new int[10001];
		int max=0;
		
		
		for(int i=0;i<n;i++) {
			arr[i][0]=sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			arr[i][1]=sc.nextInt();
			max+=arr[i][1];
		}
		
		for(int i=0;i<n;i++) {
			for(int j=max;j>=arr[i][1];j--) {
				dp[j]=Math.max(dp[j], dp[j-arr[i][1]]+arr[i][0]);
			}
		}
		
		for(int i=0;i<=max;i++) {
			if(dp[i]>=m) {
				System.out.print(i);
				break;
			}
			
		}
		

		
	}

}
