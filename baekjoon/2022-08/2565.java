import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int arr[][]=new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			
		});
		
		int dp[]=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=1;j<i;j++) {
				if(arr[i][1]>arr[j][1]) {
					dp[i]=Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		
		int result=0;
		for(int i=1;i<=N;i++) {
			result=Math.max(result, dp[i]);
		}
		
		System.out.println(N-result);

	}

}