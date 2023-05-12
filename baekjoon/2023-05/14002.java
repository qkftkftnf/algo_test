import java.util.Arrays;
import java.util.Scanner;

// 가장 긴 증가하는 부분 수열
public class Main {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int num=0;
		
		int arr[]=new int[N];
		int dp[]=new int[N];
		
		Arrays.fill(dp, 1);
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}num=Math.max(num, dp[i]);
		}
		
		System.out.println(num);
		int answer[]=new int[num];
		Arrays.fill(answer, Integer.MAX_VALUE);
		
		for(int i=N-1;i>=0;i--) {
			if(num==dp[i]) {
				answer[--num]=arr[i];
			}
		}
		
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
		
		
	}
}
