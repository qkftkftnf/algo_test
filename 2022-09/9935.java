import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String line=br.readLine();
		String n=br.readLine();
		
		int len=line.length();
		int nlen=n.length();
		
		Stack<Character> st=new Stack<Character>();
		
		
		if(len>=nlen) {
			for(int i=0;i<len;i++) {
				st.push(line.charAt(i));
				
				if(st.size()>=nlen) {
					boolean boom=true;
					
					for(int j=0;j<nlen;j++) {
						if(st.get(st.size()-nlen+j) != n.charAt(j)) {
							boom= false;
							break;
						}
					}
					if(boom) {
						for(int j=0;j<nlen;j++) {
							st.pop();
						}
					}
				}
				
			}
		}
		
		if(st.isEmpty()) {
			sb.append("FRULA");
		}else {
			for(int i=0;i<st.size();i++) {
				sb.append(st.get(i).toString());
			}
		}
		
		System.out.print(sb);
		

	}

}
