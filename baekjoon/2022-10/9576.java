import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static class pos implements Comparable<pos>{
		int a,b;

		public pos(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(pos o) {
			if(this.b==o.b) {
				return o.a-this.a;
			}
			return this.b-o.b;
		}
	}
	public static LinkedList<pos> list;
	public static int arr[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			
			int N=sc.nextInt();
			int M=sc.nextInt();
			int result=0;
			
			list=new LinkedList<>();
			arr=new int[N+1];
			
			for(int i=0;i<=N;i++) {
				arr[i]=i;
			}
			
			for(int i=0;i<M;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				list.add(new pos(a,b));
			}
			
			Collections.sort(list);
			
			for(int i=0;i<M;i++) {
				pos cur=list.get(i);
				if(find(cur.a)>N)continue;
				if(find(cur.a)<=cur.b) {
					result++;
					union(cur.a);
				}
			}
			
				System.out.println(result);
			
			}
		
		
	}
	
	public static int find(int a) {
		if(arr[a]>=arr.length) return Integer.MAX_VALUE;
		if(arr[a]==a) return a;
		else return arr[a]=find(arr[a]);
	}
	
	public static void union(int a) {
		int fa=find(a);
		arr[fa]+=1;

	}

}