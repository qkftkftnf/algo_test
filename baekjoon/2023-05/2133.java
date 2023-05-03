import java.util.Scanner;

// 타일 채우기
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		long dp[]=new long[N+1];
		if(N%2!=0) System.out.print(0);
		else {
			dp[0]=1;
			dp[2]=3;
			
			for(int i=4;i<=N;i+=2) {
				dp[i]=(4*dp[i-2])-dp[i-4];
			}
			System.out.print(dp[N]);
		}
		
	}

}
