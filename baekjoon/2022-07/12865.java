import java.util.Scanner;

public class Main {

	static int min=Integer.MAX_VALUE;
	public static int N,arr[][],asum=0;
	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		
		arr=new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=sc.nextInt();
				
			}
		}
		
		
		check(0,1,new boolean[N+1]);
		System.out.println(min);
	}
	
	public static void check(int count,int start,boolean visited[]) {
		if(count==N/2) {
			int a=0;
			int b=0;
			int ar[]=new int[N/2];
			int br[]=new int[N/2];
			for(int i=1;i<=N;i++) {
				if(visited[i]) {
					ar[a++]=i;
				}else {
					br[b++]=i;
				}
			}ch(0,0,new boolean[N/2],ar);
			a=asum;
			asum=0;
			ch(0,0,new boolean[N/2],br);
			b=asum;
			asum=0;
			min=Math.min(Math.abs(a-b),min);
		}
		
		
		
		for(int i=start;i<=N;i++) {
			if(visited[i])continue;
			visited[i]=true;
			check(count+1,i+1,visited);
			visited[i]=false;
		}
	}
	
	public static void ch(int count,int start,boolean visited[],int cc[]) {
		if(count==2) {
			int a[]=new int[2];
			int num=0;
			for(int i=0;i<N/2;i++) {
				if(visited[i]) {
					a[num++]=cc[i];
				}
			}asum+=arr[a[0]][a[1]]+ arr[a[1]][a[0]];
		}
		for(int i=start;i<N/2;i++) {
			if(visited[i])continue;
			visited[i]=true;
			ch(count+1,i+1,visited,cc);
			visited[i]=false;
		}
	}
	
	

}