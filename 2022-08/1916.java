import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N,M,arr[][],s,f;
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			Arrays.fill(arr[i],100002);
		}
		
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int dis=sc.nextInt();
			
			
			arr[a][b]=Math.min(arr[a][b], dis);
		}
		
		s=sc.nextInt();
		f=sc.nextInt();

		boolean[] visited = new boolean[N+1]; 

		int[] distance = new int[N+1]; 
		Arrays.fill(distance, Integer.MAX_VALUE-1);

		distance[s] = 0;

		for(int i = 1; i < N; i++) { 
			int min = Integer.MAX_VALUE;
			int index = -1;

			
			for(int j = 1; j <= N; j++) { 
				if(!visited[j] && distance[j] < min) {
					min = distance[j];  
					index = j; 
				}
			}
			
			visited[index] = true;
			for (int j = 1; j < N+1; j++) { 
				if (!visited[j] && arr[index][j] != 100002 && distance[index] + arr[index][j] < distance[j]) { 
					distance[j] = distance[index] + arr[index][j];
				}
			}
		}

		System.out.println(distance[f]);

		
	}
	
}