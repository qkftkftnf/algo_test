import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		int dp[][]=new int[K+1][N+1];
		
		for(int i=0;i<=N;i++) {
			dp[1][i]=1;
			
		}
			
		for(int j=1;j<=K;j++) {
			for(int i=0;i<=N;i++) {
				for(int s=0;s<=i;s++) {
					dp[j][i]=(dp[j][i]+dp[j-1][s])%1000000000;
				}
					
			}
		}
		System.out.println(dp[K][N]);
	}

}
