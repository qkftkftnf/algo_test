import java.util.PriorityQueue;

class Solution {
    public static class pos implements Comparable<pos>{
        int x,dis;
        
        public pos(int x,int dis){
            super();
            this.x=x;
            this.dis=dis;
        }
        
        public int compareTo(pos o){
            return this.x-o.x;
        }
    }
    
    public int[] solution(int[] numbers) {
        int n=numbers.length;
        int[] answer = new int[n];
        PriorityQueue<pos> pq=new PriorityQueue<>();    
        
        for(int i=0;i<n;i++){
            if(pq.isEmpty()){
                pq.offer(new pos(numbers[i],i));
            }else{
                while(pq.peek().x<numbers[i]){
                    pos cur=pq.poll();
                    answer[cur.dis]=numbers[i];
                    if(pq.isEmpty()) break;
                }
                pq.offer(new pos(numbers[i],i));
            }
        }
        
        while(!pq.isEmpty()){
            answer[pq.poll().dis]=-1;
        }
        
        
        return answer;
    }
}