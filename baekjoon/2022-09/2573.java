import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int arr[][],minus[][],N,M;
	public static int dx[]= {0,1,0,-1};
	public static int dy[]= {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String NM[]=br.readLine().split(" ");

		N=Integer.parseInt(NM[0]);
		M=Integer.parseInt(NM[1]);
		
		arr=new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			String line[]=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(line[j]);
			}
		}
		int result=0;
		int D=1;
		
		while(D==1) {
			
			D=check();
			if(D==0) {
				result=0;
				break;
			}
			
			if(D==1)result++;
			minus();
			
			
		}
		System.out.println(result);
	
		
		
	}
	
	
	public static int check() {
		int result=0;
		boolean visited[][]=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0 && !visited[i][j]) {
					DFS(i,j,visited);
					result++;
				}
			}
		}
		return result;
	}
	
	public static void minus() {
		minus=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0) {
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx>=0 && ny>=0 && nx<N && ny<M &&arr[nx][ny]==0) {
							minus[i][j]++;
						}
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j]-=minus[i][j];
				if(arr[i][j]<0) arr[i][j]=0;
			}
		}
	}
	public static void DFS(int x,int y,boolean visited[][]) {
		visited[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && arr[nx][ny]!=0) {
				DFS(nx,ny,visited);
			}
		}
	}

}
