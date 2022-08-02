import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n=sc.nextInt();
			
				
			int dp[]=new int[n+3];
			dp[1]=1;
			dp[2]=2;
			dp[3]=4;
				
			if(n>3) {
				for(int i=4;i<=n;i++) {
					dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
				}
			}
			System.out.println(dp[n]);	
				
		}
	}
}
