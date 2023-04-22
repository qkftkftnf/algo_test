import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//PPAP
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String line[]=br.readLine().split("");
		Stack<String> st =new Stack<>();
		String result="PPAP";
		
		for(int i=0;i<line.length;i++) {
			if(line[i].equals("A") ) {
				if(st.size()>1 && i<line.length-1 && line[i+1].equals("P")) {
					st.pop();
					st.pop();
				}else {
					result="NP";
					break;
				}
			}else {
				st.push(line[i]);
			}
		}
		if(st.size()>1)result="NP";
	
		
		System.out.println(result);
		
	}
	
}
