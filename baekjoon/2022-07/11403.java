import java.util.Scanner;

public class Main {
	public static int N,arr[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		arr=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==0)arr[i][j]=10001;
			}
		}
		
		
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==10001 ) {
					arr[i][j]=0;
				}else {
					arr[i][j]=1;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		
	}
}
