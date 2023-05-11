import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 탈출
public class Main {
	public static class pos implements Comparable<pos>{
		int x,y,dis;
		
		public pos(int x,int y,int dis) {
			super();
			this.x=x;
			this.y=y;
			this.dis=dis;
		}
		
		public int compareTo(pos e) {
			return this.dis-e.dis;
		}
	}
	public static int dx[]= {-1,0,1,0};
	public static int dy[]= {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<pos> pq=new PriorityQueue<pos>();
		Queue<pos> q=new LinkedList<pos>();
		
		String line[]=br.readLine().split(" ");
		
		int R=Integer.parseInt(line[0]);
		int C=Integer.parseInt(line[1]);
		boolean check=false;
		
		String arr[][]=new String[R][C];
		boolean visited[][]=new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			line=br.readLine().split("");
			for(int j=0;j<C;j++) {
				arr[i][j]=line[j];
				if(line[j].equals("S")) {
					pq.offer(new pos(i,j,0));
				}
			}
		}
		int num=0;
		
		loop:
		while(!pq.isEmpty()) {

			pos cur=pq.poll();
			
			if(cur.dis!=num) {
				num++;
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(arr[i][j].equals("*"))q.offer(new pos(i,j,0));
					}
				}
				while(!q.isEmpty()) {
					pos current=q.poll();
					for(int i=0;i<4;i++) {
						int nx=current.x+dx[i];
						int ny=current.y+dy[i];
						if(nx>=0 && ny>=0 && nx<R && ny<C && arr[nx][ny].equals("."))arr[nx][ny]="*";
					}
				}
			}
			
			for(int i=0;i<4;i++) {
				int nx=cur.x+dx[i];
				int ny=cur.y+dy[i];
				if(nx>=0 && ny>=0 &&nx<R && ny<C && !visited[nx][ny] && !arr[nx][ny].equals("*") && !arr[nx][ny].equals("X")) {
					
					if(arr[nx][ny].equals("D")) {
						System.out.println(cur.dis+1);
						check=true;
						break loop;
					}
					boolean water=false;
					for(int j=0;j<4;j++) {
						int cx=nx+dx[j];
						int cy=ny+dy[j];
						if(cx>=0 && cy>=0 && cx<R && cy<C &&arr[cx][cy].equals("*")) {
							water=true;
							break;
						}
					}
					
					if(water)continue;
					
					
					visited[nx][ny]=true;
					pq.offer(new pos(nx,ny,cur.dis+1));
				}
			}
		}
		
		if(!check)System.out.println("KAKTUS");
	}
}
