//우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다.
//어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
//두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
//예를 들어 어떤 A, B 두 사람의 덩치가 각각 (56, 177), (45, 165) 라고 한다면 A의 덩치가 B보다 큰 셈이 된다.
//그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다.
//예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고, 키는 C가 더 크므로, "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.
//N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
import java.util.*;

public class Main {
		
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int x[]=new int[50];
		int y[]=new int[50];
		int rank[]=new int[50];
		
		for(int i=0;i<a;i++) {
			x[i]=scan.nextInt();
			y[i]=scan.nextInt();
			rank[i]=1;	
		}
		
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				if(x[i]>x[j] && y[i]>y[j])
					rank[j]++;
			}
		}
		
		for(int i=0;i<a;i++) {
			System.out.print(rank[i]+" ");
		}
		
	}
		
}