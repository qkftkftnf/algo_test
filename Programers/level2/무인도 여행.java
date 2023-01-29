import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static class pos{
        int x, y;
        
        public pos(int x,int y){
            super();
            this.x=x;
            this.y=y;
        }
    }
    public static PriorityQueue<Integer> pq=new PriorityQueue<>();
    public static int dx[]={0,-1,0,1};
    public static int dy[]={1,0,-1,0};
    public int[] solution(String[] maps) {
        int n=maps.length;
        int m=maps[0].length();
        
        int[] answer ;
        String arr[][]=new String[n][m];
        String line[];
        
        for(int i=0;i<n;i++){
            line=maps[i].split("");
            for(int j=0;j<m;j++){
                arr[i][j]=line[j];
            }
        }
        
        bfs(arr,new boolean[n][m],n,m);
        if(pq.isEmpty()){
            answer=new int[1];
            answer[0]=-1;
        }else{
            int idx=0;
            answer=new int[pq.size()];
            while(!pq.isEmpty()){
                answer[idx++]=pq.poll();
            }
        }
        
        return answer;
    }
    
    public static void bfs(String arr[][],boolean visited[][],int n,int m){
        Queue<pos> q=new LinkedList<>();
        int num=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                num=0;
                if(!arr[i][j].equals("X") && !visited[i][j]){
                    num+=Integer.parseInt(arr[i][j]);
                    q.offer(new pos(i,j));
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        pos cur=q.poll();
                        for(int k=0;k<4;k++){
                            int nx=cur.x+dx[k];
                            int ny=cur.y+dy[k];
                            if(nx>=0 && ny>=0 && nx<n && ny<m &&!visited[nx][ny] && !arr[nx][ny].equals("X")){
                                num+=Integer.parseInt(arr[nx][ny]);
                                q.offer(new pos(nx,ny));
                                visited[nx][ny]=true;
                            }
                        }
                    }
                    if(num!=0)pq.offer(num);
                }
                
            }
        }
        
    }
}