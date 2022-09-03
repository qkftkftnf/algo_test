import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
public static int dx[]={0,1,0,-1};
public static int dy[]= {1,0,-1,0};
public static class pos{
	int x;
	int y;
	public pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		int arr[][]=new int[N+1][N+1];
		
		for(int i=0;i<K;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			arr[x][y]=1;
		}
		
		
		
		int L=sc.nextInt();
		int time[]=new int[L+1];
		String head[]=new String[L+1];
		
		for(int i=0;i<L;i++) {
			time[i]=sc.nextInt();
			head[i]=sc.next();
			
		}
		Queue<pos> q=new LinkedList<>();
		arr[1][1]=2;
		int turn=0;
		int result=0;
		int dir=0;
		int sx=1;
		int sy=1;
		q.offer(new pos(sx,sy));
		while(true) {
			sx+=dx[dir];
			sy+=dy[dir];
			q.offer(new pos(sx,sy));
			if(sx< 1 || sy<1 || sx>N || sy>N) break;
			if(arr[sx][sy]==2) break;
			if(arr[sx][sy]!=1) {
				pos tail=q.poll();
				arr[tail.x][tail.y]=0;
			}
			arr[sx][sy]=2;
			result++;
			if(result==time[turn]) {
				if(head[turn].contentEquals("L")) {
					dir--;
					if(dir<0) dir+=4;
				}else {
					dir++;
					dir%=4;
				}
				turn++;
			}
			
		}
		result++;
		System.out.println(result);
		
		

	}

}