import java.util.*;

public class Main {
	public static class pos implements Comparable<pos>{
		int to,cost;

		public pos(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(pos o) {
			return this.cost-o.cost;
		}
	}
	public static LinkedList<pos> list[];
	public static int n,d,c,arr[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int result=0;
			int maxnum=Integer.MIN_VALUE;
			n=sc.nextInt();
			d=sc.nextInt();
			c=sc.nextInt();
			
			list=new LinkedList[n+1];
			
			for(int i=1;i<=n;i++) {
				list[i]=new LinkedList<Main.pos>();
			}
			
			for(int i=0;i<d;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				int s=sc.nextInt();
				
				list[b].add(new pos(a,s));
			}
			
			
			dik(c);
			for(int i=1;i<=n;i++) {
				if(arr[i] !=Integer.MAX_VALUE) {
					result++;
					maxnum=Math.max(maxnum, arr[i]);
				}
			}
			sb.append(result).append(" ").append(maxnum).append("\n");
		}
		System.out.println(sb);

	}
	
	public static void dik(int start) {
		PriorityQueue<pos> pq=new PriorityQueue<Main.pos>();
		arr=new int[n+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[start]=0;
		
		pq.offer(new pos(start,0));
		
		while(!pq.isEmpty()) {
			pos cur=pq.poll();
			
			for(pos x:list[cur.to]) {
				if(arr[x.to]>cur.cost+x.cost) {
					arr[x.to]=cur.cost+x.cost;
					pq.offer(new pos(x.to,arr[x.to]));
				}
			}
		}
	}
}
