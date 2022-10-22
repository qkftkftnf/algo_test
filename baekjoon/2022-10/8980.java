import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static class pos implements Comparable<pos>{
		int a,b,num;

		public pos(int a, int b,int num) {
			super();
			this.a = a;
			this.b = b;
			this.num = num;
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
			
			int N=sc.nextInt();
			int C=sc.nextInt();
			int M=sc.nextInt();
			int result=0;
			
			list=new LinkedList<>();
			arr=new int[N+1];
			
			
			for(int i=0;i<M;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				int num=sc.nextInt();
				list.add(new pos(a,b,num));
			}
			
			Collections.sort(list);
			
			
			for(int i=0;i<M;i++) {
				pos cur=list.get(i);
				int start=cur.a;
				int end=cur.b;
				int min=cur.num;
				for(int j=start;j<end;j++) {
					if(min>C-arr[j]) {
						min=C-arr[j];
					}
				}
				if(min==0) continue;
				for(int j=start;j<end;j++) {
					arr[j]+=min;
				}
				result+=min;
			
			}
			System.out.println(result);
			
	}
	
	

}
