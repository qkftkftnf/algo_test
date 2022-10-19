import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class pos implements Comparable<pos>{
		public pos(int y, int cost) {
			super();
			this.y = y;
			this.cost = cost;
		}

		int y,cost;

		@Override
		public int compareTo(pos o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
	}
	public static int N,K,result;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		K=sc.nextInt();
		result=0;
		if(N==0 && K!=0) {
			N=1;
			result=1;
		}
		
		
		bfs(N);
		System.out.println(result);
		
		
	}
	
	public static void bfs(int start) {
		PriorityQueue<pos> pq=new PriorityQueue<>();
		boolean visited[]=new boolean[100001];
		
		pq.offer(new pos(start,result));
		while(!pq.isEmpty()) {
			pos cur=pq.poll();
			visited[cur.y]=true;
			if(cur.y==K) { 
				result=cur.cost;
				return;
			}
			if(2*cur.y<=100000 &&!visited[cur.y*2]) {
				pq.offer(new pos(cur.y*2,cur.cost));
			}
			if(cur.y+1<=100000 && !visited[cur.y+1]) {
				pq.offer(new pos(cur.y+1,cur.cost+1));
			}
			if(cur.y>=1 && !visited[cur.y-1]) {
				pq.offer(new pos(cur.y-1,cur.cost+1));
			}
		}
		
	}

}
