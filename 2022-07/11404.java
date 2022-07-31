import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int INF=10000001;
		int arr[][]=new int[n+1][n+1];
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j]=INF;
			}
		}
		
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			arr[a][b]=Math.min(arr[a][b], c);
			
		}

		
		
		
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);
				}
			}
		}
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==INF || i==j) {
					arr[i][j]=0;
				}
				System.out.print(arr[i][j]+ " ");
			}System.out.println();
		}
		
	}

}
