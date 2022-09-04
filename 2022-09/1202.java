import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Collections;

public class Main {
	
	public static PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());
	public static long sum=0L;
	public static class pos implements Comparable<pos>{
		int size;
		int money;
		public pos(int size, int money) {
			super();
			this.size = size;
			this.money = money;
		}
		@Override
		public int compareTo(pos o) {
			if(this.size== o.size) {
				return o.money - this.money;
			}
			return this.size - o.size;
		}
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		pos arr[] =new pos[N];
		int bag[]=new int[K];
		
		for(int i=0;i<N;i++) {
			int size=sc.nextInt();
			int money=sc.nextInt();
			
			arr[i]=new pos(size,money);
		}
		
		for(int i=0;i<K;i++) {
			bag[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		Arrays.sort(bag);
		
		
		int j=0;
		for(int i=0;i<K;i++) {
			while(j<N && bag[i]>=arr[j].size) {
				q.offer(arr[j++].money);
			}
			
			if(!q.isEmpty()) {
				sum+=q.poll();
			}
			
		}
		System.out.print(sum);
	}

}