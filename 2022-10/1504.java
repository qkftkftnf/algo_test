import java.util.Scanner;

public class Main {
	public static int N,E,arr[][];
	public static int INF=100000000;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		E=sc.nextInt();
		int result=0;
		arr=new int[N+1][N+1];
		
		for(int i=0;i<E;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			arr[a][b]=arr[b][a]=c;
		}
		
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) arr[i][j]=0;
				else if(arr[i][j]==0)arr[i][j]=INF;
			}
		}
		
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i!=j)
					arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);
				}
			}
		}
		
		
		int s=sc.nextInt();
		int e=sc.nextInt();
		
		
		result=Math.min(arr[1][s]+arr[e][N], arr[1][e]+arr[s][N])+arr[s][e];
		if(result>=INF)result=-1;
		System.out.println(result);
	}

}
