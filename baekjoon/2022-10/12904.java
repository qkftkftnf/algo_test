import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int result=0;
		String S=br.readLine();
		StringBuffer T=new StringBuffer(br.readLine());
		
		boolean head=true;
		
		while(S.length()!= T.length()) {
			
			if(head) {
				if(T.charAt(T.length()-1) == 'A') {
					T.deleteCharAt(T.length()-1);
				}else {
					T.deleteCharAt(T.length()-1);
					head=!head;
				}	
			}else {
				if(T.charAt(0)=='A') {
					T.deleteCharAt(0);
				}else {
					T.deleteCharAt(0);
					head=!head;
				}
			}
			
		}
		
		if(!head)T=T.reverse();
		String a=T.toString();
		
		if(a.equals(S))result=1;
		System.out.println(result);
	}

}
