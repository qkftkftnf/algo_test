import java.util.LinkedList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len=elements.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        
        for(int i=1;i<=len;i++){
            for(int j=0;j<len;j++){
                int num=0;
                for(int k=0;k<i;k++){
                    int pos=(j+k)%len;
                    num+=elements[pos];
                }
                pq.offer(num);
            }
        }
        int start=0;
        while(!pq.isEmpty()){
            if(start!=pq.peek()){
                answer++;
            }
            start=pq.poll();
        }

        return answer;
    }
}