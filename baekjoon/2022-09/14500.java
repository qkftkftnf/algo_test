import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N,M,arr[][],max=Integer.MIN_VALUE;
	public static int dx[]= {1,0,-1,0};
	public static int dy[]= {0,1,0,-1};
	public static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String NM[]=br.readLine().split(" ");
		N=Integer.parseInt(NM[0]);
		M=Integer.parseInt(NM[1]);
		
		arr=new int[N][M];
		visited=new boolean[N][M];
		for(int i=0;i<N;i++) {
			String line[]=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(line[j]);
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited[i][j]=true;
				dfs(i,j,arr[i][j],1);
				visited[i][j]=false;
				
				exception(i,j);
			}
		}

		System.out.println(max);
	}
	
	
	private static void exception(int x, int y) {
		int wing=4;
		int min=Integer.MAX_VALUE;
		int sum=arr[x][y];
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(wing<=2)return;
			if(nx<0 || ny<0 ||nx>=N || ny>=M) {
				wing--;
				continue;
			}
			min=Math.min(arr[nx][ny], min);
			sum+=arr[nx][ny];
		}
		if(wing==4) {
			sum-=min;
		}
		max=Math.max(sum, max);
		
	}


	public static void dfs(int x,int y,int sum,int count) {
		if(count==4) {
			max=Math.max(sum, max);
			return;
		}
		

		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny]) {
				visited[nx][ny]=true;
				dfs(nx,ny,sum+arr[nx][ny],count+1);
				visited[nx][ny]=false;
			}
		}
		
	}
	

}
