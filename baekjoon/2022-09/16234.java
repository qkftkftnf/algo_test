import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static class pos{
		int x,y,num;

		public pos(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	public static int dx[]= {0,1,0,-1};
	public static int dy[]= {1,0,-1,0};
	public static int N,R,L,A[][],result,index;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		L=sc.nextInt();
		R=sc.nextInt();
		A=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				A[i][j]=sc.nextInt();
			}
		}

		
		
		while(true) {
			index=0;
			bfs();
			if(index== N*N)break;
			result++;
		}
		System.out.println(result);
	}
	public static void bfs() {
		boolean visited[][]=new boolean[N][N];
		Queue<pos> q= new LinkedList<pos>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					index++;
					Stack<pos> st=new Stack();
					int total=A[i][j];
					visited[i][j]=true;
					q.offer(new pos(i,j,A[i][j]));
					while(!q.isEmpty()) {
						pos cur=q.poll();
						st.push(cur);
						for(int k=0;k<4;k++) {
							int nx=cur.x+dx[k];
							int ny=cur.y+dy[k];
							if(nx>=0 && ny>=0 && nx<N && ny<N ) {
								int cha=Math.abs(A[nx][ny]-A[cur.x][cur.y]);
								if(!visited[nx][ny] && cha>=L && cha<=R) {
									q.offer(new pos(nx,ny,A[nx][ny]));
									visited[nx][ny]=true;
									total+=A[nx][ny];
								}
							}
						}
					}
					
					for(int k=0;k<st.size();k++) {
						pos cur=st.get(k);
						A[cur.x][cur.y]=(total/st.size());
					}
				}
			}
		}
	}
}
