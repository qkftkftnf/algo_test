import java.util.Scanner;

public class Main {
	public static int N,M,arr[][],result=1;
	public static int dx[]= {-1,0,1,0};
	public static int dy[]= {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[N][M];
		
		int x=sc.nextInt();
		int y=sc.nextInt();
		int dir=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		clean(x,y,dir);
		System.out.println(result);
		
		
	}
	
	public static void clean(int x,int y, int dir) {
		arr[x][y]=2;
		
		
		for(int i=0;i<4;i++) {
			dir=(dir+3)%4;
			
			int nx=x+dx[dir];
			int ny=y+dy[dir];
			if(nx<0 || ny<0 || nx>=N || ny>=M)continue; 
			if(arr[nx][ny]==0) {
				result++;
				clean(nx,ny,dir);
				return;
			}
		}
		
		int d=(dir+2)%4;
		int nx=x+dx[d];
		int ny=y+dy[d];
		
		if(nx>=0 && ny>=0 && nx<N && ny<M &&arr[nx][ny]!=1) {
			clean(nx,ny,dir);
		}
	
		
		
	}
	

}
