import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
        long answer = 0;
        
        for(int i=0;i<works.length;i++){
            pq.offer(works[i]);
        }
        
        for(int i=0;i<n;i++){
            if(pq.isEmpty()) return answer;
            int num=pq.poll();
            if(num>0)pq.offer(num-1);
        }
        while(!pq.isEmpty()){
            answer+=(long)Math.pow(pq.poll(),2);
        }
        return answer;
    }
}