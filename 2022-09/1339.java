import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int result=0;
		
		String line=" ";
		LinkedList<Integer> num = new LinkedList<>();
		
		for(int i=0;i<26;i++) {
			num.add(0);
		}
		
		for(int i=0;i<N;i++) {
			line=br.readLine();
			
			
			for(int j=0;j<line.length();j++) {
				char a=line.charAt(j);
				num.set(a-'A', num.get(a-'A')+(int) Math.pow(10, line.length()-j-1));
			}
		}
		Collections.sort(num,Collections.reverseOrder());
		
		for(int i=9;i>=0;i--) {
			result+=(i*num.get(9-i));
		}
		
		System.out.println(result);
	}

}
