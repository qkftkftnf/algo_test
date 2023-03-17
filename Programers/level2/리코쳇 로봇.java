import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static class pos{
        int x,y,dis;
        
        public pos(int x,int y,int dis){
            super();
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }
    public static int dx[]={-1,0,1,0};
    public static int dy[]={0,-1,0,1};
    public static int n,m,answer=Integer.MAX_VALUE;
    
    public int solution(String[] board) {
        answer = -1;
        
        int sx=0;
        int sy=0;
        
        n=board.length;
        m=board[0].length();
        
        String arr[][]=new String[n][m];
        boolean visited[][]=new boolean[n][m];
        
        
        for(int i=0;i<n;i++){
            String line[]=board[i].split("");
            for(int j=0;j<m;j++){
                arr[i][j]=line[j];
                if(arr[i][j].equals("R")){
                    sx=i;
                    sy=j;
                }
            }
        }
        
        bfs(arr,visited,sx,sy);
        
        return answer;
    }
    
    public static void bfs(String arr[][],boolean visited[][],int sx,int sy){
        Queue<pos> q=new LinkedList<>();
        
        q.offer(new pos(sx,sy,0));
        visited[sx][sy]=true;
        
        while(!q.isEmpty()){
            pos cur=q.poll();
            
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                
                while(nx<n && nx>=0 && ny<m && ny>=0 && !arr[nx][ny].equals("D")){
                    nx+=dx[i];
                    ny+=dy[i];
                }
                nx-=dx[i];
                ny-=dy[i];
                if(visited[nx][ny])continue;
                if(arr[nx][ny].equals("G")){
                    answer=cur.dis+1;
                    return;
                }
                visited[nx][ny]=true;
                q.offer(new pos(nx,ny,cur.dis+1));
                
            }
        }
        
        
        
    }
}