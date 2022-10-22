import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static int N, mom[];
	static LinkedList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		mom = new int[N + 1];
		mom[1]=1;
		list=new LinkedList[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i]=new LinkedList<>();
		}
		int a, b;
		for (int i = 0; i < N - 1; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}

		dfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(mom[i]);

		}
	}

	public static void dfs(int start) {
		
		while(!list[start].isEmpty()) { 
			int num=list[start].poll();
			while(mom[num]!=0 && !list[start].isEmpty()) {
				num=list[start].poll();
			}
			if(mom[num]==0)mom[num]=start;
			dfs(num);
		}
	}
}
