import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 택배 배송
public class Main {
	public static class pos implements Comparable<pos>{
		int to,count;
		
		public pos(int to,int count) {
			super();
			this.to=to;
			this.count=count;
		}
		
		public int compareTo(pos o) {
			return this.count-o.count;
		}
	}
	public static int N,M;
	public static LinkedList<pos>[] list;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		list=new LinkedList[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i]=new LinkedList<pos>();
		}
		
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			list[a].add(new pos(b,c));
			list[b].add(new pos(a,c));
		}
		dik();
	}

public static void dik() {
	PriorityQueue<pos> pq=new PriorityQueue<pos>();
	int arr[]=new int[N+1];
	Arrays.fill(arr, Integer.MAX_VALUE);
	arr[1]=0;
	pq.offer(new pos(1,0));
	
	while(!pq.isEmpty()) {
		pos cur=pq.poll();
		
		for(pos x:list[cur.to]) {
			if(arr[x.to]<=cur.count+x.count)continue;
			arr[x.to]=cur.count+x.count;
			pq.offer(new pos(x.to,arr[x.to]));
		}
	}
	System.out.println(arr[N]);
}

}
