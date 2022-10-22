//M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();

		
		for(int i=a;i<=b;i++) {
			int n=(int)Math.sqrt(i);
			for(int j=1;j<=n;j++) {
				if(i%j==0 && j!=1 || i==1) {
					break;
				}
				else if(j==n)
					System.out.println(i);				
			}		
		}
		
	}
}