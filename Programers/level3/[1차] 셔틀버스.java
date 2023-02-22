import java.util.PriorityQueue;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq=new PriorityQueue();
        for(String s: timetable){
            String line[]=s.split(":");
            int num=Integer.parseInt(line[0])*60+Integer.parseInt(line[1]);
            pq.offer(num);
        }
        
        int bustime=540;
        int count=0;
        int time=0;
        int ans=0;
        
        for(int i=0;i<n;i++){
            count=0;
            while(!pq.isEmpty()){
                if(pq.peek()>bustime) break;
                else{
                    count++;
                    time=pq.poll();
                    if(count==m) break;
                    
                }
            }
            bustime+=t;
        }
        
        if(count==m) ans=time-1;
        else ans=bustime-t;
        
        String hour=String.format("%02d",ans/60);
        String min=String.format("%02d",ans%60);
        String answer=hour+":"+min;
        return answer;
    }
}