import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class pos implements Comparable<pos>{
		int p,d;

		public pos(int p, int d) {
			super();
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(pos o) {
			if(this.d==o.d) {
				return o.p-this.p;
			}
			return this.d-o.d;
		}
	}
	public static PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
	public static LinkedList<pos>list=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int result=0;
		for(int i=0;i<n;i++) {
			int p=sc.nextInt();
			int d=sc.nextInt();
			list.add(new pos(p,d));
		}
		Collections.sort(list);
		
		for(int i=0;i<n;i++) {
			if(pq.size()<list.get(i).d) {
				pq.offer(list.get(i).p);
			}else if(pq.peek()<list.get(i).p){
				pq.poll();
				pq.offer(list.get(i).p);
			}
		}
		
		while(!pq.isEmpty()) {
			result+=pq.poll();
		}
		System.out.println(result);
	}

}
