import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int arr[][]=new int[N][2];
		int dp[][]=new int[N][N];
		
		String line[];
		
		for(int i=0;i<N;i++) {
			line=br.readLine().split(" ");
			arr[i][0]=Integer.parseInt(line[0]);
			arr[i][1]=Integer.parseInt(line[1]);
		}
		
		
		for(int i=1;i<N;i++) {
			for(int j=0;i+j<N;j++) {
				dp[j][i+j]=Integer.MAX_VALUE;
				for(int k=j;k<i+j;k++) {
					int num=dp[j][k]+dp[k+1][j+i]+arr[j][0]*arr[k][1]*arr[j+i][1];
					dp[j][j+i]=Math.min(dp[j][j+i], num);
				}
			}
		}
		
		System.out.print(dp[0][N-1]);
	}

}
