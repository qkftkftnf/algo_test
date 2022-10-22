//bfs를 활용 
//dfs로도 문제를 해결할 수 있을 것으로 보였으나 이런류의 문제는 bfs가 더 빠를 거 같다고 판단해서 bfs를 사용하였음


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static class pos {
		int x,y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static int dx[]= {1,0,-1,0,1,1,-1,-1};
	public static int dy[]= {0,-1,0,1,1,-1,-1,1};
	public static int w,h,result,arr[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			w=sc.nextInt();
			h=sc.nextInt();
			
			result=0;
			
			if(w==0 &&h==0) {
				break;
			}
			arr=new int[h][w];
			
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					arr[i][j]=sc.nextInt();
					
				}
			}
			bfs(new boolean[h][w]);
			System.out.println(result);
		}	
	}

	
	public static void bfs(boolean visited[][]) {
		Queue<pos> queue=new LinkedList<>();
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					result++;
					queue.offer(new pos(i,j));
					visited[i][j]=true;
					while(!queue.isEmpty()) {
						pos p =queue.poll();
						int nx,ny;
						for(int k=0;k<8;k++) {
							nx=p.x+dx[k];
							ny=p.y+dy[k];
							if(nx>=0 && nx<h && ny>=0 && ny<w &&arr[nx][ny]==1 && !visited[nx][ny]) {
								visited[nx][ny]=true;
								queue.offer(new pos(nx,ny));
							}
						}
					}
				}
			}
		}	
	}
}
