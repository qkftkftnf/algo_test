import java.util.Scanner;

public class Main {
	public static int N,result=0;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		
		int arr[][]=new int[N][N];
		
		check(0,new boolean[N][N]);
		System.out.println(result);

	}
	
	public static void check(int x,boolean visited[][]) {
		if(x==N) {
			result+=1;
			return;
		}
		ne:for(int i=0;i<N;i++) {
			int nx=x;
			int ny=i;
			while(nx-1>=0 && ny-1>=0 ) {
				nx-=1;
				ny-=1;
				if(visited[nx][ny]) {
					continue ne;
				}
			}
			nx=x;
			ny=i;
			while(nx-1>=0 && ny+1<N ) {
				nx-=1;
				ny+=1;
				if(visited[nx][ny]) {
					continue ne;
				}
			}
			nx=x;
			ny=i;
			while(nx-1>=0) {
				nx-=1;
				if(visited[nx][ny]) continue ne;
			}
			visited[x][i]=true;
			check(x+1,visited);
			visited[x][i]=false;
		}
	}

}