import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//마법사 상어와 파이어 스톰
public class Main {
	public static class pos{
		int x,y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static int dx[]= {-1,0,1,0};
	public static int dy[]= {0,1,0,-1};
	public static int N,Q,n,arr[][],tar[][],result=Integer.MIN_VALUE,total;
	public static boolean visited[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line[]=br.readLine().split(" ");
		
		N=Integer.parseInt(line[0]);
		Q=Integer.parseInt(line[1]);
		
		n=(int)Math.pow(2, N);
		
		arr=new int[n][n];
		
		for(int i=0;i<n;i++) {
			line=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(line[j]);
			}
		}
		
		line=br.readLine().split(" ");
		for(int k=0;k<Q;k++) {
			turn(Integer.parseInt(line[k]));
			cal();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				total+=arr[i][j];
			}
		}
		bfs();
		
		if(result==Integer.MIN_VALUE)result=0;
		System.out.println(total);
		System.out.println(result);
		
		
	}
	
	public static void turn(int L) {
		int l=(int)Math.pow(2,L);
		tar=new int[l][l];
		
		for(int i=0;i<n;i+=l) {
			for(int x=0;x<n;x+=l) {
				for(int j=i;j<i+l;j++) {
					for(int k=x;k<x+l;k++) {
						tar[k%l][l-(j%l)-1]=arr[j][k];
						
					}
				}
				for(int j=i;j<i+l;j++) {
					for(int k=x;k<x+l;k++) {
						arr[j][k]=tar[j%l][k%l];
					}
				}
			}
		}
	}
	
	public static void cal() {
		Queue<pos> q=new LinkedList<pos>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int count=0;
				for(int k=0;k<4;k++) {
					int nx=i+dx[k];
					int ny=j+dy[k];
					if(nx>=0 && ny>=0 &&nx<n && ny<n && arr[nx][ny]>0) count++;
				}
				if(count<3)q.offer(new pos(i,j));
			}
		}
		while(!q.isEmpty()) {
			pos cur=q.poll();
			if(arr[cur.x][cur.y]>0) arr[cur.x][cur.y]--;
		}
	}
	
	public static void bfs() {
		visited=new boolean[n][n];
		Queue<pos> q=new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j] && arr[i][j]>0) {
					int count=0;
					q.offer(new pos(i,j));
					visited[i][j]=true;
					while(!q.isEmpty()) {
						count++;
						pos cur=q.poll();
						for(int k=0;k<4;k++) {
							int nx=cur.x+dx[k];
							int ny=cur.y+dy[k];
							if(nx>=0 && ny>=0 &&nx<n && ny<n && arr[nx][ny]>0 && !visited[nx][ny]) {
								visited[nx][ny]=true;
								q.offer(new pos(nx,ny));
							}
						}
					}
					
					result=Math.max(count, result);
				}
			}
		}
	}
}
