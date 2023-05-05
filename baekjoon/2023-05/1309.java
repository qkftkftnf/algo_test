import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		long dp[][]=new long[N+1][3];
		int mod=9901;
		
		dp[1][0]=1;
		dp[1][1]=1;
		dp[1][2]=1;
		
		for(int i=2;i<=N;i++) {
			dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%mod;
			dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
			dp[i][2]=(dp[i-1][0]+dp[i-1][1])%mod;
		}
		System.out.print((dp[N][0]+dp[N][1]+dp[N][2])%mod);
		
		
	
	}

}
