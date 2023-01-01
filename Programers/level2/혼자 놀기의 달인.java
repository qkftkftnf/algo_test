import java.util.*;

class Solution {
    public static boolean visited[];
    public int solution(int[] cards) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        visited=new boolean[cards.length];
        
        for(int i=0;i<cards.length;i++){
            if(!visited[i])pq.offer(dfs(cards,0,i));
        }
        if(pq.size()>1) answer=pq.poll() * pq.poll();
        return answer;
    }
    
    public static int dfs(int cards[],int num,int i){
        if(visited[i]){
            return num;
        }
        
        visited[i]=true;
        return dfs(cards,num+1,cards[i]-1);
    }
}