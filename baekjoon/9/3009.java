//세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x1=scan.nextInt();
		int y1=scan.nextInt();
		int x2=scan.nextInt();
		int y2=scan.nextInt();
		int x3=scan.nextInt();
		int y3=scan.nextInt();
		int x4,y4;
			
		if(x1!=x2 && x1!=x3)
			x4=x1;
		else if(x2 != x1 && x2 != x3)
			x4=x2;
		else
			x4=x3;
		
		if(y1!=y2 && y1!=y3)
			y4=y1;
		else if(y2 != y1 && y2 != y3)
			y4=y2;
		else
			y4=y3;
		
		System.out.println (x4+" "+y4);
	}
}