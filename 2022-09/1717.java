import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int num[];

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		String Line[]=br.readLine().split(" ");
		int n=Integer.parseInt(Line[0]);
		int m=Integer.parseInt(Line[1]);
		num=new int[n+1];
		
		for(int i=0;i<=n;i++) {
			num[i]=i;
		}
		for(int i=0;i<m;i++) {
			Line=br.readLine().split(" ");
			int order=Integer.parseInt(Line[0]);
			int a=Integer.parseInt(Line[1]);
			int b=Integer.parseInt(Line[2]);
			
			if(order==0) {
				union(a,b);
			}else {
				if(findP(a)==findP(b)) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.print(sb);

	}
	
	public static int findP(int a) {
		if(num[a]==a)return a;
		else return num[a]=findP(num[a]);
	}
	
	public static void union(int a, int b) {
		int Pa=findP(a);
		int Pb=findP(b);
		if(Pa != Pb) {
			num[Pa]=Pb;
		}
	}

}
