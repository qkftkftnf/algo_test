import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int K=sc.nextInt();
			
			if(K==0) {
				break;
			}
			
			int S[]=new int[K];
			for(int i=0;i<K;i++) {
				S[i]=sc.nextInt();
			}
			
			result(0,0,K,S,new boolean[K]);
			System.out.println();
		}
	}
	
	public static void result(int count,int start,int K, int S[],boolean visited[]) {
		
		if(count==6) {
			for(int i=0;i<K;i++) {
				if(visited[i])
					System.out.print(S[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<K;i++) {
			if(visited[i])continue;
			visited[i]=true;
			result(count+1,i,K,S,visited);
			visited[i]=false;
		}
		
		
	}

}
