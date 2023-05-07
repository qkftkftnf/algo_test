import java.util.Scanner;

// 파이프 옮기기1
public class Main {
	public static int arr[][],N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		arr=new int[N+1][N+1];
		int dp[][][]=new int[N+1][N+1][3];
		//가로 0 세로 1 대각2
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		dp[1][2][0]=1;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				for(int k=0;k<3;k++) {
					if(k!=1) {
						if(ga(i,j))dp[i][j+1][0]+=dp[i][j][k];
					}
					if(k!=0) {
						if(se(i,j))dp[i+1][j][1]+=dp[i][j][k];
					}
					if(de(i,j))dp[i+1][j+1][2]+=dp[i][j][k];
				}
			}
		}
		
		
	
		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
		

	}

	public static boolean ga(int x,int y) {
		
		if(y+1<=N &&arr[x][y+1]!=1)return true;
		else return false;
	}

	public static boolean se(int x,int y) {
		if(x+1<=N && arr[x+1][y]!=1)return true;
		else return false;
	}

	public static boolean de(int x,int y) {
		if(ga(x,y) && se(x,y) && arr[x+1][y+1] !=1 )return true;
		else return false;
	}

}
