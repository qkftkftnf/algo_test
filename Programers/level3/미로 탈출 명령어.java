import java.util.PriorityQueue;

class Solution {
    
    public static class pos implements Comparable<pos>{
        int x,y,dis;
        String res;
        
        public pos(int x,int y,int dis,String res){
            super();
            this.x=x;
            this.y=y;
            this.dis=dis;
            this.res=res;
        }
        
        public int compareTo(pos e){
            return this.res.compareTo(e.res);
        }
    }
    public static int dx[]={1,0,0,-1};
    public static int dy[]={0,-1,1,0};
    public static String str[]={"d","l","r","u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
        PriorityQueue<pos> pq=new PriorityQueue<>();
        pq.offer(new pos(x,y,0,""));
        
        loop:
        while(!pq.isEmpty()){
            pos cur=pq.poll();
            
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                
                if(nx>0 && ny>0 && nx<=n &&ny<=m && cur.dis<k){
                    int num=Math.abs(nx-r)+Math.abs(ny-c);
                    if(num>k-(cur.dis+1))continue;
                    if((k-(cur.dis+1)-num)%2==1)continue;
                    
                    if(nx==r &&ny==c &&cur.dis==k-1){
                        answer=cur.res;
                        answer+=str[i];
                        break loop;
                    }else{
                        pq.offer(new pos(nx,ny,cur.dis+1,cur.res+str[i]));
                    }
                }
            }
        }
        
        
        
        
        
        return answer;
    }
}