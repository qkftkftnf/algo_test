import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//트리의 지름
public class Main {
	public static class pos implements Comparable<pos>{
		int to,cost;

		public pos(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(pos o) {
			return o.cost-this.cost;
		}
	}
	public static int n,result,arr[];
	public static ArrayList<pos> list[];
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		list=new ArrayList[n+1];
		result=Integer.MIN_VALUE;
	
		for(int i=0;i<=n;i++) {
			list[i]=new ArrayList();
		}
		for(int i=0;i<n-1;i++) {
			String line[]=br.readLine().split(" ");
			int a=Integer.parseInt(line[0]);
			int b=Integer.parseInt(line[1]);
			int c=Integer.parseInt(line[2]);
			list[a].add(new pos(b,c));
			list[b].add(new pos(a,c));
		}
		for(int i=1;i<=n;i++) {
			Collections.sort(list[i]);
		}
		

		for(int i=1;i<=n;i++) {
			visited=new boolean[n+1];
			visited[i]=true;
			dfs(i,0);
		}
		System.out.println(result);

	}
	
	public static void dfs(int start,int num) {
		
		for(pos x: list[start]) {
			if(!visited[x.to]) {
				visited[x.to]=true;
				dfs(x.to,num+x.cost);
			}
		}
		result=Math.max(result, num);
	}
	
}
