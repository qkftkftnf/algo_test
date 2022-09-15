import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static class lec implements Comparable<lec>{
		int start,end;

		public lec(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(lec o) {
			// TODO Auto-generated method stub
			return this.start-o.start;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(br.readLine());
		lec arr[]=new lec[N];
		 for(int i=0;i<N;i++) {
			 String Line[]=br.readLine().split(" ");
			 int s=Integer.parseInt(Line[0]);
			 int e=Integer.parseInt(Line[1]);
			 
			 arr[i]=new lec(s,e);
		 }
		 
		 Arrays.sort(arr);
		 
		 PriorityQueue<Integer> pq=new PriorityQueue<>();
		 pq.offer(arr[0].end);
		 
		 for(int i=1;i<N;i++) {
			 if(pq.peek() <= arr[i].start) {
				 pq.poll();
			 }
			 pq.offer(arr[i].end);
		 }
		 
		 System.out.println(pq.size());
		
	}

}
