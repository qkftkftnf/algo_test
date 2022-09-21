import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int dx[]= {-1,0,1};
	public static int dy[]= {1,1,1};
	public static int R,C,result=0;
	public static String arr[][];
	public static class pos{
		int x,y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String RC[]=br.readLine().split(" ");
		
		R=Integer.parseInt(RC[0]);
		C=Integer.parseInt(RC[1]);
		
		arr=new String[R+1][C+1];
	
		
		for(int i=1;i<=R;i++) {
			String line[]=br.readLine().split("");
			for(int j=1;j<=C;j++) {
				arr[i][j]=line[j-1];
			}
		}
		
		
		for(int i=1;i<=R;i++) {
			if(find(i,1)) result++;
		}
		
		
		System.out.println(result);
	}
	public static boolean find(int x,int y) {
		arr[x][y]="x";
		
		if(y==C-1) return true;
		
		if(x-1>0 && arr[x-1][y+1].equals(".")) {
			if(find(x-1,y+1)) 
			return true; 
		}
		
		if(arr[x][y+1].equals(".")) {
			if(find(x,y+1)) 
			return true; 
		}
		
		if(x+1<=R && arr[x+1][y+1].equals(".")) {
			if(find(x+1,y+1))
			return true; 
		}
		return false;
	}
}