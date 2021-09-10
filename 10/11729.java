//세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 
//각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
//한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
//쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
//이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
import java.util.*;

public class Main {
	public static void hanoi(StringBuilder sb, int a, char fro, char cen, char back){
		if(a==1) sb.append(fro+" "+back+"\n");
		else {
			hanoi(sb,a-1,fro,back,cen);
			sb.append(fro+" "+back+"\n");
			hanoi(sb,a-1,cen,fro,back);
		}
			
	}
	
	public static void main(String[] args) {	
		StringBuilder sb = new StringBuilder();
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		
		int count=(int) Math.pow(2, a)-1;
		
		hanoi(sb,a,'1','2','3');
		System.out.println(count);
		System.out.println(sb);
	}
		
}