import java.util.PriorityQueue;

class Solution {
    public static class pos implements Comparable<pos>{
        int num,count;
        
        public pos(int num,int count){
            super();
            this.num=num;
            this.count=count;
        }
        
        public int compareTo(pos o){
            return this.count-o.count;
        }
    }

    public int solution(int x, int y, int n) {
        int answer=bfs(x,y,n,0);
        return answer;
    }
    
    
    public static int bfs(int x,int y,int n,int count){
        if(x==y)return 0;
        PriorityQueue<pos> pq=new PriorityQueue<>();
        boolean visited[]=new boolean[1000001];
        
        pq.offer(new pos(x,0));
        
        while(!pq.isEmpty()){
            pos cur=pq.poll();
            if(cur.num+n==y || cur.num*2==y || cur.num*3==y){
                return cur.count+1;
            }
            
            if(cur.num+n<y && !visited[cur.num+n]){
                pq.offer(new pos(cur.num+n,cur.count+1));
                visited[cur.num+n]=true;
            }
            if( cur.num*2<y && !visited[cur.num*2]){
                pq.offer(new pos(cur.num*2,cur.count+1));
                visited[cur.num*2]=true;
            }
            if(cur.num*3<y &&!visited[cur.num*3] ){
                pq.offer(new pos(cur.num*3,cur.count+1));
                visited[cur.num*3]=true;
            }
        }
        
        return -1;
    }
}