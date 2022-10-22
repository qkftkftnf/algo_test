import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb=new StringBuilder();
			String line[]=br.readLine().split("");
			int len=line.length;
			int n=Integer.parseInt(br.readLine());
			Deque<Integer> list=new ArrayDeque<>();
			String array=br.readLine().replace("[", "").replace("]", "");
			String arr[]=array.split(",");
			for(int i=0;i<n;i++) {
				list.add(Integer.parseInt(arr[i]));
			}
			boolean go=true;
			try {
				for(int i=0;i<len;i++) {
					if(line[i].equals("R")) {
						go = !go;
					}else if(line[i].equals("D")) {
						if(go) {
							list.remove();
						}else {
							list.removeLast();
						}
					}	
				}
				n=list.size();
				sb.append("[");
				for(int i=0;i<n;i++) {
					if(!go) {
						sb.append(list.pollLast()).append(",");
					}else {
						sb.append(list.poll()).append(",");
					}
				}
				if(sb.length()>1) {
					sb.deleteCharAt(sb.length()-1);
				}
				sb.append("]");
				System.out.println(sb);
			}catch(Exception e) {
				System.out.println("error");
			}
		
			
			
			
		}

	}

}
