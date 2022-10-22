import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static class pos implements Comparable<pos>{
		int x,y,dis;

		public pos(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		@Override
		public int compareTo(pos o) {
			return this.dis-o.dis;
		}
	}
	public static int N,arr[][],result=Integer.MAX_VALUE;
	public static int dx[]= {0,1,0,-1};
	public static int dy[]= {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		
		arr=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line[]=br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(line[j]);
			}
		}
	
		Bfs(0,0,0,new boolean[N][N]);
		System.out.println(result);
	}

	
	public static void Bfs(int x,int y,int count,boolean visited[][]) {
		PriorityQueue<pos> q=new PriorityQueue();
		q.offer(new pos(x,y,count));
		
		while(!q.isEmpty()) {
			pos c=q.poll();
			visited[c.x][c.y]=true;
			if(c.x==N-1 && c.y==N-1) {
				result=Math.min(result, c.dis);
				break;
			}
			for(int i=0;i<4;i++) {
				int nx=dx[i]+c.x;
				int ny=dy[i]+c.y;
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
					
					if(arr[nx][ny]==0)q.offer(new pos(nx,ny,c.dis+1));
					else q.offer(new pos(nx,ny,c.dis));
				}
			}
		}		
		
		
	}
}
