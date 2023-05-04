import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int num=100000;
		int N=sc.nextInt();
		int k=sc.nextInt();
		
		int arr[]=new int[N];
		int dp[]=new int[k+1];
		
		
		Arrays.fill(dp, num);
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
			if(k>=arr[i])dp[arr[i]]=1;
		}
		
		Arrays.sort(arr);
		
		for(int i=1;i<=k;i++) {
			for(int j=0;j<N;j++) {
				if(arr[j]>i)break;
				dp[i]=Math.min(dp[i],dp[i-arr[j]]+1);
			}
		}
		
		if(dp[k]==num)System.out.print(-1);
		else System.out.println(dp[k]);
		
		
		
		
	
	}

}
