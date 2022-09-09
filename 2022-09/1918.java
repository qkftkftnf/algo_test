import java.util.Scanner;
import java.util.Stack;

public class Main {
public static StringBuilder sb=new StringBuilder();
public static String Line;
public static int len,num=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Line=sc.nextLine();
		len=Line.length();
		
		cal();
		System.out.println(sb);
		
	}
	
	public static void cal() {
		Stack<Character> st=new Stack<>();
		
		for(int i=num;i<len;i++) {
			char ss=Line.charAt(i);
			if(ss>='A' && ss<='Z') {
				sb.append(ss);
			
			}else if(ss == '(') {
				st.push(ss);
			}else if(ss == ')') {
				while(!st.isEmpty()) {
					if(st.peek() =='(') {
						st.pop();
						break;
					}
					sb.append(st.pop());
				}
			}else  {
				while(!st.isEmpty() && pri(st.peek()) >= pri(ss)) {
					sb.append(st.pop());
				}
				st.push(ss);
			}
		}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
	}
	
	public static int pri(char ss) {
		if(ss == '(') return 0;
		else if(ss == '+' || ss=='-') return 1;
		else return 2;
	}

}
