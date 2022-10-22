import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

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
	public static LinkedList<pos> list[];
	public static int N,M,arr[],route[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String line[];
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		list=new LinkedList[N+1];
		
		for(int i=0;i<N+1;i++) {
			list[i]=new LinkedList<pos>();
		}
		
		for(int i=0;i<M;i++) {
			line =br.readLine().split(" ");
			int a=Integer.parseInt(line[0]);
			int b=Integer.parseInt(line[1]);
			int c=Integer.parseInt(line[2]);
			
			list[a].add(new pos(b,c));
		}
		
		line = br.readLine().split(" ");
		int start=Integer.parseInt(line[0]);;
		int end=Integer.parseInt(line[1]);;
		
		dik(start,end);
		StringBuilder sb=new StringBuilder();
		sb.append(arr[end]+"\n");
		
		Stack<Integer> st=new Stack<>();
		st.push(end);
		int count=1;
		while(route[end] !=0) {
			count+=1;
			st.push(route[end]);
			end=route[end];
		}
		sb.append(count+"\n");
		while(!st.isEmpty()) {
			sb.append(st.pop()+" ");
		}
		System.out.println(sb);
	}
	
	
	public static void dik(int start,int end) {
		PriorityQueue<pos> pq=new PriorityQueue<pos>();
		arr=new int[N+1];
		route=new int[N+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		
		arr[start]=0;
		pq.offer(new pos(start,0));
		
		while(!pq.isEmpty()) {
			
			pos cur=pq.poll();
			int to=cur.to;
			
			if(arr[to]<cur.cost) continue;
			for(pos x:list[to]) {
				if(arr[x.to]>x.cost+cur.cost) {
					arr[x.to]=x.cost+cur.cost;
					route[x.to]=cur.to;
					pq.offer(new pos(x.to,arr[x.to]));
				}
			
				
				
			}
			
		}
		
		
	}

}
