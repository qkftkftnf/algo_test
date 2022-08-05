import java.util.Scanner;

public class Main {
	public static int N,count=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		
		int num[]=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			num[i]=sc.nextInt();
		}	
		int up[]=cal(num);
		
		int num2[]=new int[N+1];
		for(int i=1;i<=N;i++) {
			num2[i]=num[N-i+1];
		}
		
		int down[]=cal(num2);
		
		int result=Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			result=Math.max(up[i]+down[N-i+1]-1,result);
		}

		System.out.println(result);
		
	}
	
	public static int[] cal(int num[]) {
		int dp[]=new int[N+1];
		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=1;j<i;j++) {
				if(num[i]>num[j]) {
					dp[i]=Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		return dp;
	}
}