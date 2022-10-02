import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
public static int N,max,arr[][],al;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			String line[]=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(line[j]);
			}
		}
		max=Integer.MIN_VALUE;
		
		find(0);
		
		System.out.println(max);

	}
	
	public static void find(int count) {
		if(count==5) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					max=Math.max(max, arr[i][j]);
					System.out.print(arr[i][j]+" ");
				}System.out.println();
			}System.out.println();
			return;
		}
		
		int ar[][]=new int[N][N];
		for(int j=0;j<N;j++) {
			ar[j]=arr[j].clone();
		}
		
		for(int k=0;k<4;k++) {
			if(k==0)up();
			else if(k==1)down();
			else if(k==2)left();
			else right();
			find(count+1);
			for(int i=0;i<N;i++) {
				arr[i]=ar[i].clone();
			}
		}
	}
	

	
	public static void left() {
		
		for(int i=0;i<N;i++) {
			Queue<Integer> st=new LinkedList();
			for(int j=0;j<N;j++) {
				if(arr[i][j]!=0) {
					st.offer(arr[i][j]);
				}
			}
			
			for(int j=1;j<=N;j++) {
				if(st.size()>1) {
					int num=st.poll();
					if(num==st.peek()) {
						num*=2;
						st.poll();
					}arr[i][j-1]=num;
				}else if(st.size()==1){
					arr[i][j-1]=st.poll();
				}else {
					arr[i][j-1]=0;
				}
			}
			
		}
	}
	
	public static void right() {
		
		for(int i=0;i<N;i++) {
			Queue<Integer> st=new LinkedList();
			for(int j=N-1;j>=0;j--) {
				if(arr[i][j]!=0) {
					st.offer(arr[i][j]);
				}
			}
			
			for(int j=N-1;j>=0;j--) {
				if(st.size()>1) {
					int num=st.poll();
					if(num==st.peek()) {
						num*=2;
						st.poll();
					}
					arr[i][j]=num;
				}else if(st.size()==1){
					arr[i][j]=st.poll();
				}else {
					arr[i][j]=0;
				}
			}
		}
	}
	public static void up() {
		
		for(int i=0;i<N;i++) {
			Queue<Integer> st=new LinkedList();
			for(int j=0;j<N;j++) {
				if(arr[j][i]!=0) {
					st.offer(arr[j][i]);
				}
			}
			
			for(int j=1;j<=N;j++) {
				if(st.size()>1) {
					int num=st.poll();
					if(num==st.peek()) {
						num*=2;
						st.poll();
					}arr[j-1][i]=num;
				}else if(st.size()==1){
					arr[j-1][i]=st.poll();
				}else {
					arr[j-1][i]=0;
				}
			}
			
		}
	}
	
	public static void down() {
		
		for(int i=0;i<N;i++) {
			Queue<Integer> st=new LinkedList();
			for(int j=N-1;j>=0;j--) {
				if(arr[j][i]!=0) {
					st.offer(arr[j][i]);
				}
			}
			
			for(int j=N-1;j>=0;j--) {
				if(st.size()>1) {
					int num=st.poll();
					if(num==st.peek()) {
						num*=2;
						st.poll();
					}arr[j][i]=num;
				}else if(st.size()==1){
					arr[j][i]=st.poll();
				}else {
					arr[j][i]=0;
				}
			}
		}
		
	}

}
