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
	public static int V,result,maxp,arr[];
	public static ArrayList<pos> list[];
	public static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();;
		list=new ArrayList[V+1];
		result=Integer.MIN_VALUE;
	
		for(int i=0;i<=V;i++) {
			list[i]=new ArrayList();
		}
		for(int i=0;i<V;i++) {
			int a=sc.nextInt();
			while(true) {
				int b=sc.nextInt();
				if(b==-1) break;
				int c=sc.nextInt();
			list[a].add(new pos(b,c));
			}
		}
		for(int i=1;i<=V;i++) {
			Collections.sort(list[i]);
		}
		

		visited=new boolean[V+1];
		visited[1]=true;
		dfs(1,0);

		visited=new boolean[V+1];
		visited[maxp]=true;
		dfs(maxp,0);
		System.out.println(result);

	}
	
	public static void dfs(int start,int num) {
		
		for(pos x: list[start]) {
			if(!visited[x.to]) {
				visited[x.to]=true;
				dfs(x.to,num+x.cost);
			}
		}
		if(result<num) {
			maxp=start;
			result=num;
		}
	}
	
}
