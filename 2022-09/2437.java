import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		String line[]=br.readLine().split(" ");
		int ar[]=new int[N];
		
		for(int i=0;i<N;i++) {
			ar[i]=Integer.parseInt(line[i]);
		}
		
		Arrays.sort(ar);
		
		int sum=0;
		for(int i=0;i<N;i++) {
			if(sum+1 <ar[i]) {
				break;
			}else {
				sum+=ar[i];
			}
		}
		System.out.println(sum+1);
	}

}
