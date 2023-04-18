import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//치즈
public class Main {
	public static class pos{
		int x,y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static int dx[]= {0,-1,0,1};
	public static int dy[]= {1,0,-1,0}; 
	public static int N,M,result=0;
	public static int arr[][];
	public static Queue<pos> q=new LinkedList<>();
	public static Queue<pos> out=new LinkedList<>();
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		check(0);
		System.out.println(result);
	}
	
	public static void check(int count) {
		boolean finish=true;
		out();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					finish=false;
					int num=0;
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny]==2) {
							num++;
						}
						if(num>=2) {
							q.offer(new pos(i,j));
							break;
						}
					}
				}
			}
		}
		while(!q.isEmpty()) {
			pos cur=q.poll();
			arr[cur.x][cur.y]=0;
		}
		
		if(finish) {
			result=count;
			return;
		}
		else check(count+1);
		
		
	}
	
	public static void out() {
		boolean visited[][]=new boolean[N][M];
		out.offer(new pos(0,0));
		visited[0][0]=true;
		
		while(!out.isEmpty()) {
			pos cur=out.poll();
			
			for(int k=0;k<4;k++) {
				int nx=cur.x+dx[k];
				int ny=cur.y+dy[k];
				if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny]!=1 && !visited[nx][ny]) {
					out.offer(new pos(nx,ny));
					visited[nx][ny]=true;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visited[i][j])arr[i][j]=2;
			}
		}
		
		
	}
	
}
