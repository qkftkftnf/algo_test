import java.util.*;

class Solution {
    public static class pos implements Comparable<pos>{
        int to;
        int dis;
        public pos(int to,int dis){
            super();
            this.to=to;
            this.dis=dis;
        }
        
        public int compareTo(pos o){
            return this.dis-o.dis;
        }
    }
    public static LinkedList<pos> list[];
    public static int answer=0;
    public int solution(int N, int[][] road, int K) {

        list=new LinkedList[N+1];
        for(int i=0;i<N+1;i++){
            list[i]=new LinkedList<>();
        }
        
        for(int i=0;i<road.length;i++){
            list[road[i][0]].add(new pos(road[i][1],road[i][2]));
            list[road[i][1]].add(new pos(road[i][0],road[i][2]));
        }
        
        dik(N,K);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        

        return answer;
    }
    
    public static void dik(int N,int K){
        PriorityQueue<pos> pq=new PriorityQueue<>();
        int arr[]=new int[N+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1]=0;
        pq.offer(new pos(1,0));
        
        while(!pq.isEmpty()){
            pos cur=pq.poll();
            int to=cur.to;
            
            for(pos x:list[to]){
                if(arr[x.to]>x.dis+cur.dis){
                    arr[x.to]=x.dis+cur.dis;
                    pq.offer(new pos(x.to,arr[x.to]));
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            if(arr[i]<=K){
                answer++;
            }
        }
        
    }
}