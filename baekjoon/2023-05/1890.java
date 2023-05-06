import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int arr[][]=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		long dp[][]=new long[N][N];
		dp[0][0]=1;
		
		int num=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==N-1 && j==N-1)continue;
				num=arr[i][j];
				if(i+num<N)dp[i+num][j]+=dp[i][j];
				if(j+num<N)dp[i][j+num]+=dp[i][j];
			}
		}

		System.out.println(dp[N-1][N-1]);
	
	}


}
