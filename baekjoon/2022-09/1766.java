import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static class pos implements Comparable<pos>{
		int x;
		int y;
		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pos o) {
			return this.x-o.x;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		String line[]=br.readLine().split(" ");
		
		int N=Integer.parseInt(line[0]);
		int M=Integer.parseInt(line[1]);

		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		LinkedList<Integer> list[]=new LinkedList[N+1];
		int ar[]=new int[N+1]; //간선의 수
		
		for(int i=0;i<=N;i++) {
			list[i]=new LinkedList<>();
		}
		
		for(int i=0;i<M;i++) {
			line=br.readLine().split(" ");
			int a=Integer.parseInt(line[0]);
			int b=Integer.parseInt(line[1]);
			
			ar[b]++;
			list[a].add(b);
		}
		
		for(int i=1;i<=N;i++) {
			if(ar[i]==0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int num=pq.poll();
			
			sb.append(num).append(" ");
			
			for(int i=0;i<list[num].size();i++) {
				int temp = list[num].get(i);
				ar[temp]--;
				if(ar[temp] == 0) pq.add(temp);
			}
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

}
