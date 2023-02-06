import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public static class pos implements Comparable<pos>{
        int start,time;
        
        public pos(int start,int time){
            super();
            this.start=start;
            this.time=time;
        }
        
        public int compareTo(pos o){
            if(this.time==o.time) return this.start-o.start;
            return this.time-o.time;
        }
    }
    
    public static PriorityQueue<pos> pq1;
    public static PriorityQueue<pos> pq2;
    public int solution(int[][] jobs) {
        int answer = 0;
        pq1=new PriorityQueue<>();
        pq2=new PriorityQueue<>();
        
        Arrays.sort(jobs,(o1,o2)->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        answer=jobs[0][1];
        
        for(int i=1;i<jobs.length;i++){
            pq1.offer(new pos(jobs[i][0],jobs[i][1]));
        }
        
        int runt=jobs[0][0]+jobs[0][1];
        int mstart=Integer.MAX_VALUE;
        int mtime=0;
        
        while(!pq1.isEmpty()){
            pos cur=pq1.poll();
            if(mstart>cur.start){
                if(mstart!=Integer.MAX_VALUE)pq2.offer(new pos(mstart,mtime));
                mstart=cur.start;
                mtime=cur.time;
            }else if(mstart==cur.start){
                if(mtime>cur.time){
                    pq2.offer(new pos(mstart,mtime));
                    mtime=cur.time;
                }else{
                    pq2.offer(cur);
                }
            }else{
                pq2.offer(cur);
            }
            
            if(pq1.isEmpty()||mstart<=runt){
                System.out.println(answer+" "+mstart+" "+mtime);
                if(mstart<=runt){
                    answer+=(runt-mstart+mtime);
                    runt+=mtime;
                } 
                else {
                    runt=mstart+mtime;
                    answer+=mtime;
                }
                
                
                mstart=Integer.MAX_VALUE;
                while(!pq2.isEmpty()){
                    pq1.offer(pq2.poll());
                }
            }
            
        }
        
        
            
        return answer/jobs.length;
    }
}