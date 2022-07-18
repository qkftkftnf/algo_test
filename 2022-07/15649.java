import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		result(0,N,M,new int[M],new boolean[N+1]);
		
	}
	
	public static void result(int start, int N, int M,int arr[],boolean visited[]) {
		if(start==M) {
			for(int i=0;i<M;i++) {
					System.out.print(arr[i]+" ");
			}System.out.println();
		}
		
		
		else {
			for(int i=1;i<=N;i++) {
				if(visited[i])continue;
				visited[i]=true;
				arr[start]=i;
				result(start+1,N,M,arr,visited);
				visited[i]=false;
			}
		}
		
		
	}

}
