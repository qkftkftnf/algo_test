import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팰린드롬?
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N+1];
		int farr[][]=new int[N+1][N+1];
		
		String line[]=br.readLine().split(" ");
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(line[i-1]);
			farr[i][i]=1;
		}
		
		for(int i=1;i<=N-2;i++) {
			if(arr[i]==arr[i+2])farr[i][i+2]=1;
		}
		for(int i=1;i<N;i++) {
			if(arr[i]==arr[i+1])farr[i][i+1]=1;
		}
		
		for(int i=2;i<N;i++) {
			for(int j=1;i+j<=N;j++) {
				if(farr[j+1][i+j-1]==1 &&arr[j]==arr[j+i]) {
					farr[j][j+i]=1;
				}
			}
		}
		
		
		int M=Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			line=br.readLine().split(" ");
			int S=Integer.parseInt(line[0]);
			int E=Integer.parseInt(line[1]);
			
			
			sb.append(farr[S][E]).append("\n");
		}
		System.out.println(sb);
		
	}
}
