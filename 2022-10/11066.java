import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int K=Integer.parseInt(br.readLine());
			
			int arr[]=new int[K+1];
			int sum[]=new int[K+1];
			int dp[][]=new int[K+1][K+1];
			
			String line[]=br.readLine().split(" ");
			for(int i=1;i<=K;i++) {
				arr[i]=Integer.parseInt(line[i-1]);
				sum[i]=sum[i-1]+arr[i];
			}
			
			
			for(int i=2;i<=K;i++) {
				for(int j=i-1;j>0;j--) {
					dp[j][i]=Integer.MAX_VALUE;
					for(int s=j;s<i;s++) {
						dp[j][i]=Math.min(dp[j][i], dp[j][s]+dp[s+1][i]);
					}
					dp[j][i]+=sum[i]-sum[j-1];
				}
			}
			
			System.out.println(dp[1][K]);
			
			
		}
	}
	
	

}
