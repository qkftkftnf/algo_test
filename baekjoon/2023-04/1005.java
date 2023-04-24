import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

//ACM Craft
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		LinkedList<Integer>[] list;
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			int N=sc.nextInt();
			int K=sc.nextInt();
			int goal=0;
			
			int arr[]=new int[N+1];
			int time[]=new int[N+1];
			int result[]=new int[N+1];
			
			list=new LinkedList[N+1];
			Queue<Integer> q=new LinkedList<>();
			
			
			for(int i=0;i<N;i++) {
				time[i+1]=sc.nextInt();
			}
			
			for(int i=0;i<=N;i++) {
				list[i]=new LinkedList<>();
			}
			
			for(int i=0;i<K;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				
				arr[b]++;
				list[a].add(b);
			}
			goal=sc.nextInt();
			
			for(int i=1;i<=N;i++) {
				if(arr[i]==0 ) {
					q.offer(i);
				}
			}
			
			for(int i=0;i<=N;i++) {
				result[i]=time[i];
			}
			

			while(!q.isEmpty()) {
				int cur=q.poll();

				for(int i:list[cur]) {
					result[i]=Math.max(result[i], result[cur]+time[i]);
					arr[i]--;
					if(arr[i]==0) {
						q.offer(i);
					}
				}
			}
			System.out.println(result[goal]);
		}

	}

}
