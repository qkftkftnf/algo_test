import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String line1[]=br.readLine().split("");
		String line2[]=br.readLine().split("");
			
		int n=line1.length;
		int m=line2.length;
		int arr[][]=new int[n+1][m+1];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(line1[i].equals(line2[j])) {
					arr[i+1][j+1]=arr[i][j]+1;
					result=Math.max(result, arr[i+1][j+1]);
				}
				
			}
		}
		System.out.println(result);
		
	}
	
	
}
