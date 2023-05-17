import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String line[];
		line=br.readLine().split(" ");
		
		int n=Integer.parseInt(line[0]);
		int m=Integer.parseInt(line[1]);
		int arr[][]=new int[n][m];
		int dp[][]=new int[n][m];
		
		for(int i=0;i<n;i++) {
			line=br.readLine().split("");
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(line[j]);
				dp[i][j]=arr[i][j];
			}
		}
		int num=0;
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) continue;
				if(i>0 && j>0 &&arr[i-1][j]==1 &&arr[i][j-1]==1 && arr[i-1][j-1]==1) {
					dp[i][j]=Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
				}
				num=Math.max(dp[i][j], num);
			}
		}
		
		
		System.out.print(num*num);
		
		
		
	}

}
