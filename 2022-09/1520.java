import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int dx[]= {0,-1,0,1};
	static int dy[]= {1,0,-1,0};
	public static int arr[][],M,N,dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			String MN[]=br.readLine().split(" ");
			M=Integer.parseInt(MN[0]); //산의 세로 크기
			N=Integer.parseInt(MN[1]); //산의 가로 크기
			
			arr=new int[M][N];
			
			
			for(int i=0;i<M;i++) {
				String line[]=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(line[j]);
				}
			}
			
			dp=new int [M][N];
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					dp[i][j]=-1;
				}
			}
			
			
	

		
		System.out.println(dfs(0,0));
		

	}

	public static int dfs(int x,int y) {
		if(x==M-1 && y== N-1) return 1;
		if(dp[x][y] != -1)return dp[x][y];
		dp[x][y]=0;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0 && ny>=0 && nx<M && ny<N && arr[nx][ny]<arr[x][y]) {
				dp[x][y]+=dfs(nx,ny);
			}
		}
		
		return dp[x][y];
	}
}