import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line[]=br.readLine().split("");
		
		int N=line.length;
		int arr[]=new int[N+1];
		int dp[]=new int[N+1];
		
		
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(line[i-1]);
		}
		
		
		dp[0]=1;
		for(int i=1;i<=N;i++) {
			if(arr[i]>=1 && arr[i]<=9) {
				dp[i]=dp[i-1];
				dp[i]%=1000000;
			}
			if(i==1)continue;
			
			int num=arr[i-1]*10 + arr[i];
			if(num>=10 &&num<=26) {
				dp[i]+=dp[i-2];
				dp[i]%=1000000;
			}
		}
		System.out.println(dp[N]);
		
	}
	
		
}