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
			return this.num-o.num;
		}
	}
	public static int dx[]= {1,0,-1,0};
	public static int dy[]= {0,1,0,-1};
	public static int M,N,result=Integer.MIN_VALUE;
	public static String arr[][];
	public static PriorityQueue<pos> q=new PriorityQueue<>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String MN[]=br.readLine().split(" ");
		
		N=Integer.parseInt(MN[0]);
		M=Integer.parseInt(MN[1]);
		
		arr=new String[N][M];
		for(int i=0;i<N;i++) {
			String line[]=br.readLine().split("");
			for(int j=0;j<M;j++) {
				arr[i][j]=line[j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j].equals("L"))bfs(i,j);
			}
		}
		
		System.out.println(result);
	}
	
	public static void bfs(int x,int y) {
		boolean visited[][]=new boolean[N][M];
		
		q.offer(new pos(x,y,0));
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			
			pos cur=q.poll();
			result=Math.max(result, cur.num);
			for(int i=0;i<4;i++) {
				int nx=cur.x+dx[i];
				int ny=cur.y+dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=M)continue;
				if(!visited[nx][ny]) {
					visited[nx][ny]=true;
					
					
					if(arr[nx][ny].equals("L"))q.offer(new pos(nx,ny,cur.num+1));
				}
			}
		}
	}

}
