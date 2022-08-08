import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int arr[]=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		
		int dp[]=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			for(int j=i;j>0;j--) {
				max=Math.max(max,arr[j]);
				min=Math.min(min,arr[j]);
				dp[i]=Math.max(dp[i], max-min+dp[j-1]);
			}
			
		}
		System.out.println(dp[N]);
		

	}

}
