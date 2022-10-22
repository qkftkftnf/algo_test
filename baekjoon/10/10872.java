//0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
import java.util.*;

public class Main {
	public static int factorial(int a) {
		if(a==0) return 1;
		else if(a==1) return 1;
		else return a*factorial(a-1);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		System.out.println(factorial(a));
	}
}