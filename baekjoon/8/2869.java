import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int day;
		
		if((c-a)%(a-b)==0)
			day=(c-a)/(a-b)+1;
		else
			day=(c-a)/(a-b)+2;
		System.out.println(day);
	}
}