//정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a =scan.nextInt();
		int b=2;
		
		while(true) {
			if(a==1) {
				break;
			}else if(a%b==0) {
				System.out.println(b);
				a/=b;
				b=2;
			}
			else
				b++;
		}
		
	}
}