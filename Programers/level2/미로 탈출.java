import java.util.PriorityQueue;

class Solution {
    public static class pos implements Comparable<pos>{
        int x,y,dis;
        
        public pos(int x,int y,int dis){
            super();
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
        
        public int compareTo(pos e){
            return this.dis-e.dis;
        }
    }
    public static int dx[]={0,1,0,-1};
    public static int dy[]={1,0,-1,0};
    public static String arr[][];
    public static int n,m;
    public int solution(String[] maps) {
        n=maps.length;
        m=maps[0].length();
        int sx=0;
        int sy=0;
        int lx=0;
        int ly=0;
        int ex=0;
        int ey=0;
        arr=new String[n][m];
        
        for(int i=0;i<n;i++){
            String line[]=maps[i].split("");
            for(int j=0;j<m;j++){
                arr[i][j]=line[j];
                if(line[j].equals("S")){
                    sx=i;
                    sy=j;
                }else if(line[j].equals("L")){
                    lx=i;
                    ly=j;
                }else if(line[j].equals("E")){
                    ex=i;
                    ey=j;
                }
            }
        }
        int a=bfs(sx,sy,lx,ly);
        int b=bfs(lx,ly,ex,ey);
        if(a==Integer.MAX_VALUE || b==Integer.MAX_VALUE) return -1;

        return a+b;
    }
    
    public static int bfs(int sx,int sy,int ex,int ey){
        int result=Integer.MAX_VALUE;
        PriorityQueue<pos> pq=new PriorityQueue<>();
        boolean visited[][]=new boolean[n][m];
        visited[sx][sy]=true;
        pq.offer(new pos(sx,sy,0));
        
        while(!pq.isEmpty()){
            pos cur=pq.poll();
            if(cur.dis>=result)continue;
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx==ex && ny==ey){
                    result=Math.min(cur.dis+1, result);
                    continue;
                }
                if(nx>=0 && nx<n && ny>=0 && ny<m &&!arr[nx][ny].equals("X") && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    pq.offer(new pos(nx,ny,cur.dis+1));
                }
            }
        }
        
        return result;    
    }
}