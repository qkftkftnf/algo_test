//재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
//크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
//
//***
//* *
//***
//N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
import java.util.*;
import java.io.*;

public class Main {
	static char stararr[][]=new char[3000][3000];
	
	public static void star(int a, int tt) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int b = a / 3;

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				if (i % 3 == 1 && j % 3 == 1) {
					stararr[i][j] = ' ';
				}
			}
		}
		if (a == 3) {
			for (int i = 0; i < tt; i++) {
				for (int j = 0; j < tt; j++) {
					bw.write( stararr[i][j]);
				}
				bw.newLine();;
			}
			bw.flush();
		}
		else {
			for (int i = 0; i < tt; i++) {
				for (int j = 0; j < tt; j++) {
					if (i %a >=a/3 && i % a < (a/3)*2&& j % a >= a / 3 && j % a < (a / 3) * 2) {
						stararr[i][j] = ' ';
					}
				}
			}
			star(b,tt);
		}
	}
	
	public static void main(String[] args) throws IOException {	
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int tt=a;
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				stararr[i][j]='*';
			}
		}
		star(a,tt);
	}
}