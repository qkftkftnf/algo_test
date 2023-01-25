import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static class pos implements Comparable<pos>{
        int x,num;
        
        public pos(int x,int num){
            super();
            this.x=x;
            this.num=num;
        }
        
        public int compareTo(pos e){
            return this.num-e.num;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,PriorityQueue<pos>> map=new HashMap<>();
        HashMap<String,Integer> map1=new HashMap<>();
        PriorityQueue<pos> pq;
        
        for(int i=0;i<genres.length;i++){
            if(!map.containsKey(genres[i])){
                pq=new PriorityQueue<>();
                pq.offer(new pos(i,plays[i]));
                map.put(genres[i],pq);
                map1.put(genres[i],plays[i]);
            }else{
                pq=map.get(genres[i]);
                pq.offer(new pos(i,plays[i]));
                while(pq.size()>2) {
                    pq.poll();
                }
                map.put(genres[i],pq);
                map1.put(genres[i],map1.get(genres[i])+plays[i]);
            }
        }
        ArrayList<String> keySet = new ArrayList(map1.keySet());
        Collections.sort(keySet, (o1, o2) -> map1.get(o2) - (map1.get(o1)));
        
        ArrayList<Integer> list=new ArrayList<>();
        
        for(String i:keySet){
            pq=map.get(i);
            while(!pq.isEmpty()){
                int nu=pq.poll().x;
                if(!pq.isEmpty())list.add(pq.poll().x);
                list.add(nu);
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}