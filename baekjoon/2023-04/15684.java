import java.util.*;

//사다리 조작
public class Main {
	public static int N,M,H,result,arr[][];
	public static boolean finish=false;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		H=sc.nextInt();
		
		arr=new int[H+1][N+1];
		
		for(int i=1;i<=M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			arr[a][b]=1;
			arr[a][b+1]=2;
		}
		for(int i=0;i<=3;i++) {
			result=i;
			dfs(1,0);
			if(finish)break;
		}
		
		
		if(finish)System.out.println(result);
		else System.out.println(-1);
	}
	public static void dfs(int x,int count) {
		if(finish) return;
		
		if(result == count) {
			if(check()) finish=true;
			return;
		}
		
		for(int i=x;i<=H;i++) {
			for(int j=1;j<N;j++) {
				if(arr[i][j]==0 && arr[i][j+1]==0) {
					arr[i][j]=1;
					arr[i][j+1]=2;
					dfs(i,count+1);
					arr[i][j]=arr[i][j+1]=0;
				}
			}
		}
	}
	
	private static boolean check() { 
		for (int i=1;i<=N;i++) { 
			int x=1,y=i;
			for (int j=0;j<H;j++) {
				if (arr[x][y] == 1) y++;
				else if (arr[x][y] == 2) y--;
				x++; 
			} 
			if (y != i) return false; 
		}
		return true; 
	} 
}
