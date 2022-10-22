//과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다.
//주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		
		
			if(a==0 && b==0 && c==0)
				break;
			else if((a*a)+(b*b)==(c*c))
				System.out.println("right");
			else if((b*b)+(c*c)==(a*a))
				System.out.println("right");
			else if((c*c)+(a*a)==(b*b))
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
}