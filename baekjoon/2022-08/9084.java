import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			int N=sc.nextInt();
			int money[]=new int[N];
			
			for(int i=0;i<N;i++) {
				money[i]=sc.nextInt();
			}
			
			int M=sc.nextInt();
			
			int dp[]=new int[M+1];
			dp[0]=1;
			for(int i=0;i<N;i++) {
				for(int j=1;j<=M;j++) {
					if(j>=money[i]) {
						dp[j]+=dp[j-money[i]];
					}
				}
			}
			
			System.out.println(dp[M]);
			
		}
	}
}
