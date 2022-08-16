import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static class pos{
		int x,count;

		public pos(int x, int count) {
			super();
			this.x = x;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		Queue<pos> queue=new LinkedList<>();
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		int result=0;
		
		boolean visit[]=new boolean[100001];
		queue.offer(new pos(N,0));
		
		while(!queue.isEmpty() &&N != K) {
			pos p=queue.poll();
			
			if(p.x-1 == K || p.x+1 == K || p.x*2 == K) {
				result=p.count+1;
				break;
			}
			else{
				if(p.x!=0 &&!visit[p.x-1]) {
					queue.offer(new pos(p.x-1,p.count+1));
					visit[p.x-1]=true;
				}
				if(p.x<100000 &&!visit[p.x+1]) {
					queue.offer(new pos(p.x+1,p.count+1));
					visit[p.x+1]=true;
				}
				if(p.x<=50000 && !visit[p.x*2]) {
					queue.offer(new pos(p.x*2,p.count+1));
					visit[p.x*2]=true;
				}
			}
			
		}
		System.out.println(result);
		
		
		
		

	}

}
