import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public static class pos implements Comparable<pos>{
        int y,dis;
        
        public pos(int y,int dis){
            super();
            this.y=y;
            this.dis=dis;
        }
        
        public int compareTo(pos o){
            return this.dis-o.dis;
        }
    }
    
    public static LinkedList<Integer> list[];
    public static int arr[];
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        list=new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            list[i]=new LinkedList<>();
        }
        
        for(int i=0;i<roads.length;i++){
            list[roads[i][0]].add(roads[i][1]);
            list[roads[i][1]].add(roads[i][0]);
        }
        
        
        dik(n,destination);
        for(int i=0;i<sources.length;i++){
            if(arr[sources[i]]==Integer.MAX_VALUE)answer[i]=-1;
            else answer[i]=arr[sources[i]];
        }
        return answer;
    }
    
    public static void dik(int n,int x){
        PriorityQueue<pos> pq=new PriorityQueue<>();
        arr=new int[n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[x]=0;
        pq.offer(new pos(x,0));
        
        while(!pq.isEmpty()){
            pos cur=pq.poll();
            
            for(int s:list[cur.y]){
                if(arr[s]<cur.dis+1)continue;
                arr[s]=cur.dis+1;
                pq.offer(new pos(s,arr[s]));
            }
        }
        
    }
}