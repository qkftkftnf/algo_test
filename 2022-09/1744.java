import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int result=0;
		
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2=new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num>0) {
				pq.offer(num);
			}else {
				pq2.offer(num);
			}
		}

		
		while(!pq.isEmpty()) {
			int a=pq.poll();
			if(pq.isEmpty()){
				result+=a;
			}else if(a*pq.peek()>a+pq.peek()) {
				result+=(a*pq.poll());
			}else {
				result+=a;
			}
		}
		
		while(!pq2.isEmpty()) {
			int a=pq2.poll();
			if(pq2.isEmpty()){
				result+=a;
			}else if(a*pq2.peek()>a+pq2.peek()) {
				result+=(a*pq2.poll());
			}else {
				result+=a;
			}
		}
		System.out.println(result);
	}

}