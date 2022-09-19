import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		int ar[]=new int[N];
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<N;i++) {
			ar[i]=sc.nextInt();
		}
		
		Arrays.sort(ar);

		for(int i=1;i<N;i++) {
			pq.offer(ar[i]-ar[i-1]);
		}
		
		int result=ar[N-1]-ar[0];
		
		for(int i=0;i<K-1;i++) {
			if(!pq.isEmpty()) {
				result-=pq.poll();
			}
		}
		System.out.println(result);
	}

}
