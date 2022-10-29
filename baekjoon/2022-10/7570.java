import java.util.*;

public class Main {
	public static boolean visited[];
	public static int N,dp[],arr[],max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
	
		arr=new int[N+1];
		dp=new int[N+1];
		visited=new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			int num=sc.nextInt();
			arr[i]=num;
			
		}
		
		visited[arr[1]]=true;
		for(int i=2;i<=N;i++) {
			if(visited[arr[i]-1]) {
				dp[arr[i]]=dp[arr[i]-1]+1;
				max=Math.max(dp[arr[i]], max);
			}
			visited[arr[i]]=true;
			
		}
		System.out.println(N-1-max);
		

	}
}
