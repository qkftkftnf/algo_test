import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int arr[]=new int[n+1];
		int min=0;
		
		int dp[]=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i]=sc.nextInt();
		}
		dp[0]=0;
		dp[1]=arr[1];
		if(n>1) dp[2]=dp[1]+arr[2];	
		for(int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-1],Math.max(dp[i-2], dp[i-3]+arr[i-1])+arr[i]);
		}
		System.out.print(dp[n]);

	}

}
