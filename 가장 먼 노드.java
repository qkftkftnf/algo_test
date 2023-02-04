import java.util.ArrayList;
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
        
        public int compareTo(pos e){
            return this.cost-e.cost;
        }
    }
    public static ArrayList<pos> list[];
    public static boolean visited[];
    public static int arr[],max;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        max=0;
        list=new ArrayList[n+1];
        arr=new int[n+1];
        visited=new boolean[n+1];
        
        for(int i=0;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            list[edge[i][0]].add(new pos(edge[i][1],1));
            list[edge[i][1]].add(new pos(edge[i][0],1));
        }
        
        find(1);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==max)answer++;
        }
        return answer;
    }
    
    public static void find(int start){
        PriorityQueue<pos> pq=new PriorityQueue<>();
        Arrays.fill(arr,100000);
        arr[start]=0;
        visited[start]=true;
        
        pq.offer(new pos(start,0));
        
        while(!pq.isEmpty()){
            pos cur=pq.poll();
            
            if(arr[cur.to]<cur.cost) continue;
            for(pos x: list[cur.to]){
                if(visited[x.to]) continue;
                arr[x.to]=cur.cost+x.cost;
                max=Math.max(arr[x.to],max);
                pq.offer(new pos(x.to,arr[x.to]));
                visited[x.to]=true;
            }
        }
        
        
    }
}