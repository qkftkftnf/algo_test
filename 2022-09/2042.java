import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static long[] arr,tree; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String line[]=br.readLine().split(" ");
		int N=Integer.parseInt(line[0]);
		int M=Integer.parseInt(line[1]);
		int K=Integer.parseInt(line[2]);
		
		arr=new long[N+1];
		tree = new long[N * 4];
		
		
		
		for(int i=1;i<=N;i++) {
			long num=Long.parseLong(br.readLine());
			arr[i]=num;
		}
		init(1,N,1);
		
		for(int i=0;i<M+K;i++) {
			line=br.readLine().split(" ");
			int a=Integer.parseInt(line[0]);
			int b=Integer.parseInt(line[1]);
			long c=Long.parseLong(line[2]);
			
			if(a==1) {
				long dif=c-arr[b];
				arr[b]=c;
				update(1,N,1,b,dif);
			}else {
				sb.append(sum(1,N,1,b,(int)c)).append("\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
	
	public static long init(int start,int end, int i) {
		if(start == end) return tree[i] = arr[start];
		
		int mid = (start+end)/2;
		
		return tree[i] = init(start,mid,i*2) + init(mid+1, end, i*2+1); 
		
	}
	
	public static void update(int start, int end, int i, int idx, long num) {
		if(idx<start || idx>end) return;
		
		tree[i]+=num;
		if(start == end) return;
		
		int mid = (start+end)/2;
		update(start,mid,i*2,idx,num);
		update(mid+1,end,i*2+1,idx,num);
		
	}
	
	public static long sum(int start,int end,int i,int left,int right) {
		if(left>end || right<start) return 0;
		
		if(left<=start && end<=right) {
			return tree[i];
		}
		
		int mid = (start+end)/2;
		
		return sum(start, mid, i*2, left, right) + sum(mid+1, end, i*2+1, left, right);
	}

}