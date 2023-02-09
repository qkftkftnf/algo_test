import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    
    public static class pos implements Comparable<pos>{
        int to,cost;
        
        public pos(int to,int cost){
            super();
            this.to=to;
            this.cost=cost;
        }
        
        public int compareTo(pos o){
            return this.cost-o.cost;
        }
    }
    public static int arr[];
    public static LinkedList<pos> list[];
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        list=new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            list[i]=new LinkedList<>();
        }
        
        for(int i=0;i<fares.length;i++){
            list[fares[i][0]].add(new pos(fares[i][1],fares[i][2]));
            list[fares[i][1]].add(new pos(fares[i][0],fares[i][2]));
        }
        
        arr=new int[n+1];
        dik(s);
        int cop[]=arr.clone();
        
        for(int i=1;i<=n;i++){
            if(cop[i]==Integer.MAX_VALUE)continue;
            dik(i);
            if(answer==0){
                answer=cop[i]+arr[a]+arr[b];
            }else{
                answer=Math.min(answer,cop[i]+arr[a]+arr[b]);
            }
        }
        
        
        
        
        return answer;
    }
    
    public static void dik(int start){
        PriorityQueue<pos> pq=new PriorityQueue<>();
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[start]=0;
        pq.offer(new pos(start,0));
        
        while(!pq.isEmpty()){
            pos cur=pq.poll();
            
            if(arr[cur.to]<cur.cost)continue;
            for(pos x:list[cur.to]){
                if(arr[x.to]<cur.cost+x.cost) continue;
                arr[x.to]=cur.cost+x.cost;
                pq.offer(new pos(x.to,arr[x.to]));
            }
        }
    }
}