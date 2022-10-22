import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class pos implements Comparable<pos>{
		int d,w;

		public pos(int d, int w) {
			super();
			this.d = d;
			this.w = w;
		}

		@Override
		public int compareTo(pos o) {
			if(this.d==o.d) {
				return o.w-this.w;
			}
			return this.d-o.d;
			
		}
	}
	public static int N;
	public static PriorityQueue<Integer> p=new PriorityQueue<>();
	public static LinkedList<pos> list=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		for(int i=0;i<N;i++) {
			list.add(new pos(sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(list);
		for(int i=0;i<N;i++) {
			if(list.get(i).d>p.size()) {
				p.offer(list.get(i).w);
			}else if(list.get(i).w>p.peek()){
				p.poll();
				p.offer(list.get(i).w);
			}
		}
		int result=0;
		while(!p.isEmpty()) {
			result+=p.poll();
		}
		System.out.println(result);
		

	}

}
