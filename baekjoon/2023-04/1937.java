import java.util.*;

public class Main {
	
	public static int dx[]= {-1,0,1,0};
	public static int dy[]= {0,1,0,-1};
	public static int n,result,max,arr[][],dp[][];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();;
		max=Integer.MIN_VALUE;
		
		arr=new int[n][n];
		dp=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				max=Math.max(max, dfs(i,j));
			}
		}

		
		System.out.println(max);

	}
	
	public static int dfs(int x,int y) {
		if(dp[x][y] != 0 )return dp[x][y];
		
		dp[x][y]=1;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || ny<0 || nx>=n || ny>=n)continue;
			if(arr[nx][ny]>arr[x][y] ) {
				dp[x][y]=Math.max(dp[x][y],dfs(nx,ny)+1);
				dfs(nx,ny);
			}
		}
		return dp[x][y];
		
	}
	
}
