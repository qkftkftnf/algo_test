import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static class pos implements Comparable<pos>{
		int x,y,num;

		public pos(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public int compareTo(pos o) {
			if(this.num==o.num) {
				
			}
			return this.num-o.num;
		}
	}
	public static int dx[]= {1,0,-1,0};
	public static int dy[]= {0,1,0,-1};
	public static int M,N,arr[][],result=0;
	public static PriorityQueue<pos> q=new PriorityQueue<>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String MN[]=br.readLine().split(" ");
		
		M=Integer.parseInt(MN[0]);
		N=Integer.parseInt(MN[1]);
		
		arr=new int[N][M];
		for(int i=0;i<N;i++) {
			String line[]=br.readLine().split("");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(line[j]);
			}
		}
		bfs(0,0);
		System.out.println(result);
	}
	
	public static void bfs(int x,int y) {
		boolean visited[][]=new boolean[N][M];
		
		q.offer(new pos(x,y,0));
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			
			pos cur=q.poll();
			for(int i=0;i<4;i++) {
				int nx=cur.x+dx[i];
				int ny=cur.y+dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=M)continue;
				if(nx==N-1 && ny==M-1) {
					result=cur.num;
					return;
				}
				if(!visited[nx][ny]) {
					visited[nx][ny]=true;
					if(arr[nx][ny]==1)q.offer(new pos(nx,ny,cur.num+1));
					else q.offer(new pos(nx,ny,cur.num));
				}
			}
		}
	}

}
