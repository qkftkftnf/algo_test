import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static class pos{
        int x,y;
        
        public pos(int x,int y){
            super();
            this.x=x;
            this.y=y;
        }
    }
    public static int dx[]={-1,0,1,0};
    public static int dy[]={0,1,0,-1};
    public static int numberOfArea;
    public static int maxSizeOfOneArea;
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea=0;
        maxSizeOfOneArea=0;
        
        bfs(picture,new boolean[m][n],m,n);
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void bfs(int[][] picture,boolean[][] visited,int m,int n){
        Queue<pos> q=new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && picture[i][j]!=0){
                    int count=0;
                    numberOfArea++;
                    q.offer(new pos(i,j));
                    visited[i][j]=true;
                    
                    while(!q.isEmpty()){
                        count++;
                        pos cur=q.poll();
                        
                        for(int k=0;k<4;k++){
                            int nx=dx[k]+cur.x;
                            int ny=dy[k]+cur.y;
                            if(nx>=0 && ny>=0 && nx<m && ny<n && !visited[nx][ny] && picture[i][j]==picture[nx][ny]){
                                q.offer(new pos(nx,ny));
                                visited[nx][ny]=true;
                            }
                        }
                    }
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,count);
                    
                }
            }
        }
        
    }
}