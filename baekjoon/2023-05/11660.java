import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int ans=0;
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int sx=0;
		int sy=0;
		int ex=0;
		int ey=0;
		
		int arr[][]=new int[N+1][N+1];
		int dp[][]=new int [N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=sc.nextInt();
				dp[i][j]=dp[i][j-1]+arr[i][j];
			}
		}
		

		
		
		for(int i=0;i<M;i++) {
			ans=0;
			sx=sc.nextInt();
			sy=sc.nextInt();
			ex=sc.nextInt();
			ey=sc.nextInt();
			
			for(int j=sx;j<=ex;j++) {
				ans+=(dp[j][ey]-dp[j][sy-1]);
			}
			sb.append(ans).append("\n");
		}
		
		
		System.out.print(sb);
		
		
		
	
	}

}
