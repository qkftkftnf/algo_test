import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int arr[]=new int[N+1];
		int dp[]=new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		dp[0]=0;
		dp[1]=arr[1];
		
		for(int i=2;i<=N;i++) {
			dp[i]=arr[i];
			for(int j=1;j<i;j++) {
				dp[i]=Math.max(arr[j]+dp[i-j], dp[i]);
			}
		}
		
		System.out.print(dp[N]);
	
	}

}
