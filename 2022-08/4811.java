import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int N=sc.nextInt();
			if(N==0) break;
			
			long dp[][]=new long[N+3][N+3];
			
			dp[0][0]=1;
			for(int h=1;h<=N+2;h++ ) {
				dp[1][h]=1;
				for(int w=1;w<=N+2;w++) {
					if(h > w) continue;
					dp[w][h]=dp[w-1][h]+dp[w][h-1];
				}
			}
			
			System.out.println(dp[N+2][N+2]);
		}
	}
}
