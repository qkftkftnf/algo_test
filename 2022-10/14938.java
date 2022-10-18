import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

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
			return this.cost-o.cost;
		}
		
		
		
	}
	public static int n,m,r,arr[],dis[];
	public static LinkedList<pos> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String line[]=br.readLine().split(" ");
		

		n=Integer.parseInt(line[0]);
		m=Integer.parseInt(line[1]);
		r=Integer.parseInt(line[2]);
		
		arr=new int[n+1];
		list=new LinkedList[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i]=new LinkedList<pos>();
		}
		
		line=br.readLine().split(" ");
		
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(line[i-1]);
		}
		
		for(int i=0;i<r;i++) {
			line=br.readLine().split(" ");
			int start=Integer.parseInt(line[0]);
			int end=Integer.parseInt(line[1]);
			int num=Integer.parseInt(line[2]);
			list[start].add(new pos(end,num));
			list[end].add(new pos(start,num));
		}
		
		
		
		int result=Integer.MIN_VALUE;
		
		for(int i=1;i<=n;i++) {
			dik(i);
			int sum=0;
			for(int j=1;j<=n;j++) {
				if(dis[j]<=m)sum+=arr[j];
			}
			result=Math.max(result,sum);
		}
		
		System.out.println(result);
	}

	public static void dik(int x) {
		PriorityQueue<pos> pq=new PriorityQueue<Main.pos>();
		dis=new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[x]=0;
		
		pq.offer(new pos(x,0));
		
		while(!pq.isEmpty()) {
			pos cur=pq.poll();
			int next=cur.to;
			
			for(pos go:list[next]) {
				if(dis[go.to]>cur.cost+go.cost) {
					dis[go.to]=cur.cost+go.cost;
					pq.offer(new pos(go.to,dis[go.to]));
				}
			}	
		}	
	}
}
