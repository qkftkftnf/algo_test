import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PriorityQueue<Integer> q=new PriorityQueue<>();
		
		int N=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			int num=sc.nextInt();
			q.offer(num);
		}
		int result=0;
		while(q.size()>1) {
			int a=q.poll();
			int b=q.poll();
			result+=(a+b);
			q.offer(a+b);
		}
		
		System.out.println(result);
		
	}

}
