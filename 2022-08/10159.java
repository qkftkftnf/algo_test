import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int arr[][]= new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i!=j) arr[i][j]=10000;
			}
		}
		
		
		
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			arr[a][b]=1;
		}
		
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);
				}
			}
		}
		for(int i=1;i<=N;i++) {
			int count=0;
			for(int j=1;j<=N;j++) {
				if(arr[i][j]==arr[j][i] && arr[i][j]==10000)
					count++;
			}System.out.println(count);
		}
		
	}
}
