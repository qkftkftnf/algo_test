import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static int dx[]={0,1,0,-1};
    public static int dy[]={-1,0,1,0};
    public static int arr[][]=new int [101][101];
    public static int answer=Integer.MAX_VALUE;
    public static class pos{
        int x,y,num;
        
        public pos(int x,int y,int num){
            super();
            this.x=x;
            this.y=y;
            this.num=num;
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int sx=0;
        int sy=0;
        int ex=0;
        int ey=0;
        for(int i=0;i<rectangle.length;i++){
            sx=2*rectangle[i][0];
            sy=2*rectangle[i][1];
            ex=2*rectangle[i][2];
            ey=2*rectangle[i][3];
            
            for(int j=sx;j<=ex;j++){
                for(int k=sy;k<=ey;k++){
                    if(arr[j][k]==2)continue;
                    if(j==sx || j==ex || k==sy|| k==ey){
                        arr[j][k]=1;
                    }else{
                        arr[j][k]=2;
                    }
                }
            }
        }
        
        bfs(characterX*2,characterY*2,itemX*2,itemY*2);

        return answer/2;
    }
    
    public static void bfs(int characterX, int characterY, int itemX, int itemY){
        boolean visited[][]=new boolean[101][101];
        Queue<pos> q=new LinkedList<>();
        q.offer(new pos(characterX,characterY,0));
        
        while(!q.isEmpty()){
            pos cur=q.poll();
            
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx>=0 && nx<101 &&ny>=0 && ny<101 && arr[nx][ny]==1 && !visited[nx][ny]){
                    if(nx==itemX &&ny==itemY){
                        answer=Math.min(cur.num+1,answer); 
                    }
                    visited[nx][ny]=true;
                    q.offer(new pos(nx,ny,cur.num+1));
                }
            }
        }
        
        

        
        
        
        
        
        
    }
}