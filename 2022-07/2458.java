import java.util.Scanner;

public class Main {
	public static int N,M,arr[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j)arr[i][j]=0;
				else {
					arr[i][j]=502;
				}
			}
		}
		
		
		for(int i=1;i<=M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();

			arr[a][b]=1;
		}
		
		floyd();
		
		int result=N;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(arr[i][j] == 502 && arr[j][i]==502) {
					result-=1;
					break;
				}
			}
		}
		System.out.println(result);

	}
	
	public static void floyd() {
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][k]+arr[k][j]<502)
					arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);
				}
			}
		}
	}

}
