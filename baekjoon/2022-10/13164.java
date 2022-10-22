import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int N,K,arr[],result=0;
	public static PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		K=sc.nextInt();
		
		arr=new int [N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=1;i<N;i++) {
			pq.offer(arr[i]-arr[i-1]);
		}
		
		for(int i=0;i<K-1;i++) {
			pq.poll();
		}
		while(!pq.isEmpty()) {
			result+=pq.poll();
		}
		System.out.println(result);
	}
}
