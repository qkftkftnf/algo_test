import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static class pos{
		int x,y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static int M,N,K,arr[][],result=0;
	static PriorityQueue<Integer>res =new PriorityQueue<>();
	public static int dx[]= {1,0,-1,0};
	public static int dy[]= {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		M=sc.nextInt();
		N=sc.nextInt();
		K=sc.nextInt();
		arr=new int[N][M];
		
		for(int i=0;i<K;i++) {
			int minx=sc.nextInt();
			int miny=sc.nextInt();
			int maxx=sc.nextInt();
			int maxy=sc.nextInt();
			for(int j=minx;j<maxx;j++) {
				for(int k=miny;k<maxy;k++) {
					arr[j][k]=1;
				}
			}
		}
		
		bfs(new boolean[N][M]);
		System.out.println(result);
		while(!res.isEmpty()) {
			System.out.print(res.poll()+" ");
		}
		

	}
	public static void bfs(boolean visited[][]) {
		Queue<pos> q=new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0 && !visited[i][j]) {
					int count=0;
					result++;
					visited[i][j]=true;
					q.offer(new pos(i,j));
					while(!q.isEmpty()) {
						count++;
						pos p=q.poll();
						for(int k=0;k<4;k++) {
							int nx=p.x+dx[k];
							int ny=p.y+dy[k];
							if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny]==0 &&!visited[nx][ny]) {
								visited[nx][ny]=true;
								q.offer(new pos(nx,ny));
							}
						}
					}res.offer(count);
				}
				
				
				
				
				
			}
		}
	}

}
