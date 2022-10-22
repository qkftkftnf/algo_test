import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int result=0;
		arr=new int[8][4];
		//오른쪽은 2 왼쪽은 6
		for(int i=0;i<4;i++) {
			String line[]=br.readLine().split("");
			for(int j=0;j<8;j++) {
				arr[j][i]=Integer.parseInt(line[j]);
			}
		}
		int k=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<k;tc++) {
			String NM[]=br.readLine().split(" ");
			int N=Integer.parseInt(NM[0])-1;
			int M=Integer.parseInt(NM[1]);			
			if(M==1) {
				turn(N,true,new boolean[4]);
				
			}else {
				turn(N,false,new boolean[4]);
			}			
		}
		for(int i=0;i<4;i++) {
			if(arr[0][i]==1)result+=Math.pow(2, i);
		}
		System.out.println(result);
	}
	
	public static void turn(int n,boolean h,boolean visited[]) {
		visited[n]=true;
		if(n+1<4 && arr[2][n] != arr[6][n+1] && !visited[n+1]) turn(n+1,!h,visited);
		if(n-1>=0 && arr[6][n] != arr[2][n-1]&& !visited[n-1]) turn(n-1,!h,visited);
		
		int temp1=0;
		int temp2=arr[0][n];
		
		if(h) {
			for(int i=1;i<8;i++) {
				temp1=arr[i][n];
				arr[i][n]=temp2;
				temp2=temp1;
			}	
		}else {
			for(int i=7;i>0;i--) {
				temp1=arr[i][n];
				arr[i][n]=temp2;
				temp2=temp1;
			}
		}arr[0][n]=temp1;
	}

}