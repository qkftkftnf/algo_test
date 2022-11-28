import java.util.*;

class Solution {
    public static int dx[]={1,0,-1,0};
    public static int dy[]={0,1,0,-1};
    public static class pos implements Comparable<pos>{
        int x;
        int y;
        int count;
        
        public pos(int x,int y,int count){
            super();
            this.x=x;
            this.y=y;
            this.count=count;
        }
        
        public int compareTo(pos o){
            return this.count-o.count;
        }
        
    }
    public int solution(int[][] maps) {
        
        int answer = -1;
        int n=maps.length;
        int m=maps[0].length;
        boolean visited[][]=new boolean[n][m];
        
        PriorityQueue<pos> pq=new PriorityQueue<>();
        
        pq.offer(new pos(0,0,1));
        visited[0][0]=true;
        while(!pq.isEmpty()){
            pos cur=pq.poll();
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && maps[nx][ny]==1 && !visited[nx][ny]){
                    if(nx==n-1 && ny==m-1 ){
                        answer=cur.count+1;
                    }
                    visited[nx][ny]=true;
                    pq.offer(new pos(nx,ny,cur.count+1));
                    
                }
            }
        }
        return answer;
    }
}