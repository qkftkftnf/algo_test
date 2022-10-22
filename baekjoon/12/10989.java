//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
import java.io.*;

public class Main {
	 private static int[] sorted=new int[10001];
	 
	 public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		int ar[]=new int[a+1];
			
		for(int i=0;i<a;i++) {
			ar[i]=Integer.parseInt(br.readLine());
			sorted[ar[i]]++;
		}
		
		
		for(int i=1;i<10001;i++) {
			while(sorted[i]>0) {
				bw.write(Integer.toString(i)+"\n");
				sorted[i]--;
			}
		}
		bw.flush();
		bw.close();
	}	 
}
	 
	
