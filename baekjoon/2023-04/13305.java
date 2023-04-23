import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//주유소
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
		long ar[]=new long[N-1];
		long arr[]=new long[N];
		long result=0;
		long dis=0;
		
		
		String line[]=br.readLine().split(" ");
		
		for(int i=0;i<line.length;i++) {
			ar[i]=Long.parseLong(line[i]);
		}
		
		line=br.readLine().split(" ");
		
		for(int i=0;i<line.length;i++) {
			arr[i]=Long.parseLong(line[i]);
		}
        
		long min=arr[0];
        
		for(int i=0;i<arr.length;i++) {
			if(i>0)dis+=ar[i-1];
			
			if(min>=arr[i] || i==arr.length-1) {
				result+=(dis*min);
				dis=0;
				min=arr[i];
			}
		}
		System.out.print(result);
	}

}
