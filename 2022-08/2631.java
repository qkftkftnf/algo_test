import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int ar[]=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			ar[i]=sc.nextInt();
		}
		
		
		int dp[]=new int[N+1];
		
		
		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=1;j<i;j++) {
				if(ar[i]>ar[j]) {
					dp[i]=Math.max(dp[j]+1,dp[i]);
				}
			}
		}
		int result=0;
		for(int i=1;i<=N;i++) {
			result=Math.max(result, dp[i]);
		}
		
		System.out.println(N-result);
	}

}
