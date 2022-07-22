import java.util.Scanner;

public class Main {

	public static int N,arr[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		
		int num=0;
		
		arr=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<=num;j++) {
				arr[i][j]=sc.nextInt();
			}
			num++;
		}
		int result[][]=new int[N][N];
		num=N;
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<num;j++) {
				if(i==N-1) {
					result[i][j]=arr[i][j];
				}else {
					result[i][j]=Math.max(result[i+1][j]+arr[i][j], result[i+1][j+1]+arr[i][j]);
				}
			}
			num--;
		}
		System.out.println(result[0][0]);

	}
	


}
