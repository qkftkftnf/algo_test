import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int ans=0;
		int N=sc.nextInt();
		int mod=10007;
		
		int dp[][]=new int [N][10];
		
		
		for(int i=0;i<10;i++) {
			dp[0][i]=1;
		}
		
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					dp[i][j]=(dp[i][j]+dp[i-1][k])%mod;
				}
			}
		}
		
		for(int i=0;i<10;i++) {
			ans+=dp[N-1][i];
		}
		System.out.print(ans%mod);
		
		
		
	
	}

}
