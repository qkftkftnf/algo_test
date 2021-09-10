//조규현과 백승환은 터렛에 근무하는 직원이다.
//하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다
//이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 
//조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
//조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 
//조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
//류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		
		
		for(int i=0;i<a;i++) {
			int x1=scan.nextInt();
			int y1=scan.nextInt();
			int r1=scan.nextInt();
			int x2=scan.nextInt();
			int y2=scan.nextInt();
			int r2=scan.nextInt();
			
			double d=Math.pow(x2-x1,2) + Math.pow(y2-y1,2);
			
			if (d == 0) {
				if (r2 == r1)
				System.out.println("-1");
			else if (r2 != r1)
				System.out.println("0");
			}
			else {
				if (d > (Math.pow(r1 + r2, 2)) || d < (Math.pow(r1 - r2, 2)))
					System.out.println("0");
				else if (d == (Math.pow(r1 + r2, 2)) || d == (Math.pow(r1 - r2, 2)))
					System.out.println("1");
				else if (d < (Math.pow(r1 + r2, 2)) || d > (Math.pow(r1 - r2, 2)))
					System.out.println("2");
			}
		}		
	}
}