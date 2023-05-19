import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 양팔저울
public class Main {
	
	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList();
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int n=sc.nextInt();
		int arr[]=new int[n];
		boolean dp[]=new boolean[15001];
		int num=0;
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			num+=arr[i];
		}
		Arrays.sort(arr);
		
		for(int i=n-1;i>=0;i--) {
			for(int j=1;j<=num;j++) {
				if(dp[j])q.offer(j);
			}
			while(!q.isEmpty()) {
				int cur=q.poll();
				dp[(int)Math.abs(cur-arr[i])]=true;
				dp[cur+arr[i]]=true;
			}
			dp[arr[i]]=true;
		}
		
		int count =sc.nextInt();

		
		for(int i=0;i<count;i++) {
			int check=sc.nextInt();
			
			if(check<=15000 &&dp[check])sb.append("Y");
			else sb.append("N");
			sb.append(" ");
		}
		System.out.println(sb);
		
		
		
	}
}
