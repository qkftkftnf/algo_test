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
			// TODO Auto-generated method stub
			return 0;
		}
	}
	public static int n,m,arr[],route[];
	public static LinkedList<pos> list[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		StringBuilder sb=new StringBuilder();
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		list=new LinkedList[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i]=new LinkedList<>();
		}
		
		for(int i=0;i<m;i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			int cost=sc.nextInt();
			list[from].add(new pos(to,cost));
			list[to].add(new pos(from,cost));
		}
		
		for(int i=1;i<=n;i++) {
			dik(i);
			for(int j=1;j<=n;j++) {
				int num=j;
				while(true) {
					if(i==num) {
						sb.append("-").append(" ");
						break;
					}
					else if(route[num]==i) {
						sb.append(num).append(" ");
						break;
					}else {
						num=route[num];
					}
				}
				
			}sb.append("\n");
		}
		System.out.print(sb);
		
		
		
	}
	
	public static void dik(int start) {
		PriorityQueue<pos> q=new PriorityQueue<>();
		arr=new int[n+1];
		route=new int[n+1];
		Arrays.fill(arr,Integer.MAX_VALUE);
		arr[start]=0;
		
		q.offer(new pos(start,0));
		
		while(!q.isEmpty()) {
			pos cur=q.poll();
			int curto=cur.to;
			for(pos x:list[curto]) {
				if(arr[x.to]>x.cost+cur.cost) {
					arr[x.to]=x.cost+cur.cost;
					route[x.to]=cur.to;
					q.offer(new pos(x.to,x.cost+cur.cost));
				}
			}
			
			
			
		}
		
	}
}
