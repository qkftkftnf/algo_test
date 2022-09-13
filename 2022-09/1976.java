//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//플루이드 워셜
//public class Main {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		
//		int N=Integer.parseInt(br.readLine());
//		int M=Integer.parseInt(br.readLine());
//		
//		int INF = 999999999;
//		int arr[][]=new int[N+1][N+1];
//		
//		
//		String line[];
//		String result="YES";
//		
//		for(int i=1;i<=N;i++) {
//			line=br.readLine().split(" ");
//			for(int j=0;j<N;j++) {
//				arr[i][j+1]=Integer.parseInt(line[j]);
//				if(i != j+1 && arr[i][j+1]==0) arr[i][j+1]=INF;
//			}
//		}
//		
//		for(int k=1;k<=N;k++) {
//			for(int i=1;i<=N;i++) {
//				for(int j=1;j<=N;j++) {
//					arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);
//				}
//			}
//		}
//		
//		int seq[]=new int[M+1];
//		
//		String line2[]=br.readLine().split(" ");
//		for(int i=0;i<M;i++) {
//			seq[i]=Integer.parseInt(line2[i]);
//		}
//		
//		for(int i=1;i<M;i++) {
//			if(arr[seq[i-1]][seq[i]] == INF) {
//				result="NO";
//				break;
//			}
//		}
//		
//		System.out.println(result);
//
//	}
//
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		arr=new int[N+1];
		int root[][]=new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]=i;
		}
		
		for(int i=1;i<=N;i++) {
			String line[]=br.readLine().split(" ");
			for(int j=1;j<=N;j++) {
				if(Integer.parseInt(line[j-1])==1) {
					union(i,j);	
				}
			}
		}
		
		String a[]=br.readLine().split(" ");
		
		int b=findP(Integer.parseInt(a[0]));
		
		String result="YES";
		
		for(int i=0;i<M;i++) {
			if(b!= findP(Integer.parseInt(a[i]))) {
				result="NO";
				break;
			}
		}
		System.out.println(result);
		

	}
	
	public static int findP(int a) {
		if(arr[a] == a) return a;
		else return arr[a]=findP(arr[a]);
	}
	
	public static void union(int a,int b) {
		int pa = findP(a);
		int pb = findP(b);
		
		if(pa != pb)arr[pa]=pb;
		
	}

}
