import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		
		int N=sc.nextInt();
		int arr[]=new int[N];
		Stack<Integer> st=new Stack<>();
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			if(st.isEmpty()) {
				st.push(i);
			}else {
				while(arr[i]>arr[st.peek()]) {
					arr[st.pop()]=arr[i];
					if(st.isEmpty()) {
						break;
					}
				}if(st.isEmpty()) {
					st.push(i);
				}else if(arr[i]<=arr[st.peek()]) {
					st.push(i);
				}
			}
			
		}
		while(!st.isEmpty()) {
			arr[st.pop()]=-1;
		}

		for(int i=0;i<N;i++) {
			sb.append(arr[i]).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
		
	}

}
