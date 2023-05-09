import java.util.PriorityQueue;
import java.util.Scanner;

// 나이트의 이동
public class Main {
	public static class pos implements Comparable<pos>{
		int x,y,count;
		
		public pos(int x,int y,int count) {
			super();
			this.x=x;
			this.y=y;
			this.count=count;
		}
		
		public int compareTo(pos e) {
			return this.count-e.count;
		}
		
	}
	public static int dx[]= {-1,-2,-2,-1,1,2,2,1};
	public static int dy[]= {-2,-1,1,2,2,1,-1,-2};

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			PriorityQueue<pos> pq=new PriorityQueue<pos>();
			int N=sc.nextInt();
			
			int arr[][]=new int[N][N];
			boolean visited[][]=new boolean[N][N];
			
			int sx=sc.nextInt();
			int sy=sc.nextInt();
			int ex=sc.nextInt();
			int ey=sc.nextInt();
			
			if(sx==ex && sy==ey)System.out.println(0);
			else pq.offer(new pos(sx,sy,0));
			
			
			loop:
			while(!pq.isEmpty()) {
				pos cur=pq.poll();
				
				for(int i=0;i<8;i++) {
					int nx=cur.x+dx[i];
					int ny=cur.y+dy[i];
					if(nx<N && ny<N && nx>=0 && ny>=0 && !visited[nx][ny]) {
						if(nx==ex && ny==ey) {
							System.out.println(cur.count+1);
							break loop;
						}
						visited[nx][ny]=true;
						pq.offer(new pos(nx,ny,cur.count+1));
					}
				}
				
				
			}
			
			
		}
		
		

	}



}
