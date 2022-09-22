import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> st=new Stack<>();
		
		String info[]=br.readLine().split(" ");
		
		int N=Integer.parseInt(info[0]);
		int K=Integer.parseInt(info[1]);
		int result=N-K;
		String line[]=br.readLine().split("");
		int num[]=new int[N];
		
		int i=0;
		while(i<N) {
			if(st.isEmpty()) {
				st.push(Integer.parseInt(line[i++]));
			}else if(st.peek()<Integer.parseInt(line[i]) && K>0) {
				st.pop();
				K--;
			}else {
				st.push(Integer.parseInt(line[i++]));
			}
		}
		
		for(i=0;i<result;i++) {
			System.out.print(st.get(i));
		}
	}


}
