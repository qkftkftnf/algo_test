import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int n;
	public static String result,arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			n=Integer.parseInt(br.readLine());
			arr=new String[n];
			result="YES";
			
			for(int i=0;i<n;i++) {
				arr[i]=br.readLine();
			}
			
			check();
			
			System.out.println(result);
			
		}
		
	}
	public static void check() {
		Arrays.sort(arr);
		for(int i=1;i<n;i++) {
			if(arr[i].startsWith(arr[i-1])) {
				result="NO";
				return;
			}
		}		
	}
	
}
