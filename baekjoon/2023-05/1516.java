import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		Queue<Integer> q =new LinkedList();
		
		int N=sc.nextInt();
		
		int arr[]=new int[N+1];
		int ind[]=new int[N+1];
		ArrayList<Integer> list[]=new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
			
			int num=sc.nextInt();
			while(num!=-1) {
				list[num].add(i);
				num=sc.nextInt();
				ind[i]++;
			}
		}
		
		int dp[]=new int[N+1];
		for(int i=1;i<=N;i++) {
			if(ind[i]==0) {
				q.offer(i);
				dp[i]=arr[i];
			}
		}
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(int i:list[cur]) {
				dp[i]=Math.max(dp[i], dp[cur]+arr[i]);
				ind[i]--;
				if(ind[i]==0) q.offer(i);
			}
		}
		
		
		for(int i=1;i<=N;i++) {
			System.out.println(dp[i]);
		}
		
		
		
		
		

		
	}
}
