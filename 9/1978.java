//주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int count=0;
		
		for(int i=0;i<a;i++) {			
			int b=scan.nextInt();
			for(int j=1;j<b;j++) {
				if(b%j==0 && j!=1 )
					break;
				else if(j==b-1)
					count++;				
			}		
		}
		System.out.print(count);
	}
}