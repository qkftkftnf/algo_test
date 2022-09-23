import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int G=Integer.parseInt(br.readLine());
		int P=Integer.parseInt(br.readLine());
		
		
		arr=new int[G+1];
		int num=0;
		int result=0;
		
		for(int i=1;i<=G;i++) {
			arr[i]=i;
		}
		for(int i=0;i<P;i++) {
			num=Integer.parseInt(br.readLine());
			int gate=find(num);
			if(gate==0) {
				break;
			}
			result++;
			union(gate,gate-1);
		}
		System.out.println(result);
	}
	
	public static int find(int a) {
		if(arr[a]==a) return a;
		else return arr[a] = find(arr[a]);
	}
	
	public static void union(int a,int b) {
		int pa=find(a);
		int pb=find(b);
		
		if(pa != pb) arr[a]=pb;
	}

}
