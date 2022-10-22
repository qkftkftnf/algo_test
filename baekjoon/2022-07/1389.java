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
				if(i==j) arr[i][j]=0;
				else arr[i][j]=5001;
			}
		}
		
		
		int a=0;
		int b=0;
		for(int i=1;i<=M;i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			arr[a][b]=1;
			arr[b][a]=1;
					
		}
		floyd();
		
		
		int min=Integer.MAX_VALUE;
		int result=0;
		for(int i=1;i<=N;i++) {
			int sum=0;
			for(int j=1;j<=N;j++) {
				sum+=arr[i][j];
			}
			if(sum<min) {
				result=i;
				min=sum;
			}
		}
		System.out.println(result);
	}
	
	public static void floyd() {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					for(int k=1;k<=N;k++) {
						arr[j][k]=Math.min(arr[j][i]+arr[i][k],arr[j][k]);
					}
				}
			}
		
		
		
		
	}

}