import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static ArrayList<Integer> list[];
	public static int V,E,ar[];
	public static String result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			result="YES";
			String VE[]=br.readLine().split(" ");
			
			V=Integer.parseInt(VE[0]);
			E=Integer.parseInt(VE[1]);
			
			ar=new int[V+1];
			list=new ArrayList[V+1];
			
			for(int i=0;i<=V;i++) {
				list[i]=new ArrayList<>();
			}
			
			int u=0;
			int v=0;
			
			for(int i=0;i<E;i++) {
				String uv[]=br.readLine().split(" ");
				u=Integer.parseInt(uv[0]);
				v=Integer.parseInt(uv[1]);
				list[u].add(v);
				list[v].add(u);
			}
			
			for(int i=1;i<=V;i++) {
				if(result.equals("NO")) break;
				if(ar[i]==0) bfs(i);
			}
			
			System.out.println(result);
			
		}
		
		
	}
	public static void bfs(int start) {
		int num=1;
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		ar[start]= num;	
		while(!q.isEmpty()) {
			int cur=q.poll();
			if(ar[cur]==1) num=2;
			else if(ar[cur]==2) num=1;
			
			for(int i=0;i<list[cur].size();i++) {
				if(ar[list[cur].get(i)] == 0) {
					ar[list[cur].get(i)]=num;
					q.offer(list[cur].get(i));
				}else if(ar[list[cur].get(i)] != num) {
					result="NO";
					return;
				}
			}
		}
			
		
		
	}

}
