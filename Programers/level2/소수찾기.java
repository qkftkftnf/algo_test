import java.util.*;
class Solution {
    public static PriorityQueue<Integer> pq=new PriorityQueue<>();
    public int solution(String numbers) {
        int answer=0;
        String num[]=numbers.split("");
        
        check(0,"",num,new boolean[num.length]);
        int s=0;
        while(!pq.isEmpty()){
            if(s!=pq.peek()){
                answer++;
            }
            s=pq.poll();
        }
        return answer;
    }
    
    public static void check(int start,String now,String[] num,boolean[] visited){
        if(start>num.length) return;
        
        if(start>0 && !now.equals("")){
            int Nnum=Integer.parseInt(now);
            boolean check=true;
            int max=(int)Math.sqrt(Nnum);
            for(int i=2;i<=max;i++){
                if(Nnum%i==0){
                    check=false;
                    break;
                }
            }
            if(check && Nnum>1) pq.offer(Nnum);
        }
        
        for(int i=0;i<num.length;i++){
            if(visited[i])continue;
            visited[i]=true;
            check(start+1,now+num[i],num,visited);
            visited[i]=false;
            check(start+1,now,num,visited);
        }
    }
}