import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        if(k>=enemy.length) return enemy.length;
        
        for(int i=0;i<k;i++){
            pq.offer(enemy[i]);
        }
        for(int i=k;i<enemy.length;i++){
            pq.offer(enemy[i]);
            n-=pq.poll();
            if(n<0) break;
            answer++;
        }
        return answer+pq.size();
    }
}