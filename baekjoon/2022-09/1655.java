import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> max=new PriorityQueue<>();
		PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
		
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			if(min.size() == max.size()) {
				min.offer(num);
			}else {
				max.offer(num);
			}
			if(!min.isEmpty() && !max.isEmpty()) {
				if(min.peek()>max.peek()) {
					max.offer(min.poll());
					min.offer(max.poll());
				}
			}
			sb.append(min.peek()).append("\n");
		}
		System.out.println(sb);
	}

}
