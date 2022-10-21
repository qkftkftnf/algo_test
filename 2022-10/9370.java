import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

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
	public static int n,m,t,s,g,h,end[],arr[];
	public static LinkedList<pos> list[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			n=sc.nextInt();
			m=sc.nextInt();
			t=sc.nextInt();
			
			s=sc.nextInt();
			g=sc.nextInt();
			h=sc.nextInt();
			
			list=new LinkedList[n+1];
			end=new int[t+1];
			for(int i=1;i<=n;i++) {
				list[i]=new LinkedList<>();
			}
			
			for(int i=0;i<m;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				int c=sc.nextInt();
				
				list[a].add(new pos(b,c));
				list[b].add(new pos(a,c));
			}
			
			for(int i=1;i<=t;i++) {
				end[i]=sc.nextInt();
			}
			Arrays.sort(end);
			
			for(int i=1;i<=t;i++) {
				int result1=dik(s,g)+dik(g,h)+dik(h,end[i]);
				int result2=dik(s,h)+dik(h,g)+dik(g,end[i]);
				int result3=dik(s,end[i]);
				
				if(Math.min(result1, result2) == result3)sb.append(end[i]).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
	
	public static int dik(int start,int end) {
		PriorityQueue<pos> pq =new PriorityQueue<>();
		arr=new int[n+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[start]=0;
		pq.offer(new pos(start,0));
		
		while(!pq.isEmpty()) {
			pos cur=pq.poll();
			
			if(arr[cur.to]<cur.cost) continue;
			for(pos x:list[cur.to]) {
				if(arr[x.to]>x.cost+cur.cost) {
					arr[x.to]=x.cost+cur.cost;
					pq.offer(new pos(x.to,arr[x.to]));
					
				}
			}
			
		}
		
		return arr[end];
	}
}
