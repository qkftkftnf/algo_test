import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class pos implements Comparable<pos>{
		int a,b;

		public pos(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(pos o) {
			if(this.a==o.a) {
				return o.b-this.b;
			}
			return this.a-o.a;
		}
	}
	public static ArrayList<pos> list;
	public static PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			int N=Integer.parseInt(br.readLine());
			int result=0;
			list=new ArrayList<>();
			
			
			for(int i=0;i<N;i++) {
				String line[]=br.readLine().split(" ");
				int a=Integer.parseInt(line[0]);
				int b=Integer.parseInt(line[1]);
				list.add(new pos(a,b));
			}
			
			Collections.sort(list);
			
			
			for(int i=0;i<N;i++) {
				pos cur=list.get(i);
				if(cur.a>pq.size()) {
					pq.offer(cur.b);
					result+=cur.b;
				}else if(pq.peek()<cur.b) {
					int num=pq.poll();
					result-=num;
					pq.offer(cur.b);
					result+=cur.b;
				}
			}
			
			System.out.println(result);
			
	}
	
	

}
