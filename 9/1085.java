//한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 
//왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
//직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int x=scan.nextInt();
		int y=scan.nextInt();
		int min1=0,min2=0;
		
		if(2*a>x)
			min1=x-a;
		else
			min1=a;
		
		if(2*b>y)
			min2=y-b;
		else
			min2=b;
		
		
		if(min1>min2)
			System.out.println(min2);
		else
			System.out.println(min1);			
	}
}