import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static class pos{
		int x,y,z;

		public pos(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static int dx[] = {1,0,-1,0,0,0};
	public static int dy[] = {0,1,0,-1,0,0};
	public static int dz[] = {0,0,0,0,-1,1};
	public static int M,N,H,arr[][][],zero;
	public static Queue<pos> q=new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String MNH[]=br.readLine().split(" ");
		
		M=Integer.parseInt(MNH[0]);
		N=Integer.parseInt(MNH[1]);
		H=Integer.parseInt(MNH[2]);
		
		arr=new int[N][M][H];
		String line[];
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				line=br.readLine().split(" ");
				for(int j=0;j<M;j++) {
					arr[i][j][k]=Integer.parseInt(line[j]);
					if(arr[i][j][k]==1)q.offer(new pos(i,j,k));
					else if(arr[i][j][k]==0)zero++;
				}
			}
		}
		
		int result=0;
		if(zero!=0)result=bfs();
		
		if(zero!=0) System.out.println(-1);
		else System.out.println(result);
	}
	public static int bfs() {
		Queue<pos> que=new LinkedList<>();
		int day=1;
		while(!q.isEmpty()) {
			pos cur=q.poll();
			for(int i=0;i<6;i++) {
				int nx=cur.x+dx[i];
				int ny=cur.y+dy[i];
				int nz=cur.z+dz[i];
				if(nx>=0 && ny>=0 && nz>=0 && nx<N && ny<M && nz<H &&arr[nx][ny][nz]==0) {
					que.offer(new pos(nx,ny,nz));
					arr[nx][ny][nz]=1;
					zero--;
				}
			}
			if(q.isEmpty() && zero!=0) {
				while(!que.isEmpty()) {
					q.offer(que.poll());
				}
				day++;
			}
		}
		return day;
	}
}
