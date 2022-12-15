import java.util.*;

class Solution {
    public static class pos implements Comparable<pos>{
        int size,count;
        
        public pos(int size,int count){
            super();
            this.size=size;
            this.count=count;
        }
        
        public int compareTo(pos o){
            return o.count-this.count;
        }
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<pos> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap();
        
        for(int i=0;i<tangerine.length;i++){
            if(!map.containsKey(tangerine[i])){
                map.put(tangerine[i],1);
            }else{
                map.put(tangerine[i],map.get(tangerine[i])+1);
            }
        }
        
        for(Integer key : map.keySet()){
            pq.offer(new pos(key,map.get(key)));
        }
        
        
        while(k>0 && !pq.isEmpty()){
            pos cur= pq.poll();
            k-=cur.count;
            answer++;
            if(k<=0) break;
            
        }
        
        return answer;
    }
}