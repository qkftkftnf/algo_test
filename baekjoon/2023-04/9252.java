import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LCS 2
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		String a=br.readLine();
		String b=br.readLine();
		String answer="";
		int count=0;
		
		
		int n=a.length();
		int m=b.length();
		int row=n;
		int col=m;
		
		int dp[][]=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		

		while(row>0 && col>0) {
			if(dp[row][col]==dp[row-1][col]) {
				row--;
			}else if(dp[row][col]==dp[row][col-1]) {
				col--;
			}else {
				sb.append(a.charAt(row-1));
				row--;
				col--;
				count++;
			}
		}
		
		
		
		System.out.println(count);
		if(count!=0)System.out.print(sb.reverse());

	
	}

}
