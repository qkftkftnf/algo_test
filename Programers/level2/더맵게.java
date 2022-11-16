import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int answer = 0;
        
        for(int i=0;i<scoville.length;i++){
            pq.offer(scoville[i]);   
        }
        
        int num=0;
        boolean check=true;
        while(pq.size()>1){
            num=pq.poll()+(2*pq.poll());
            pq.offer(num);
            answer++;
            if(pq.peek()>=K){
                check=false;
                break;
            }
        }
        if(check)answer=-1;
        
        
        
        return answer;
    }
}