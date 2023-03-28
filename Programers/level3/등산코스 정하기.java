import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public static class pos implements Comparable<pos>{
        int to,dis;
        
        public pos(int to,int dis){
            super();
            this.to=to;
            this.dis=dis;
        }
        
        public int compareTo(pos o){
            return this.dis-o.dis;
        }
    } 
    public static ArrayList<pos> list[];
    public static int answer[];
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        answer = new int[2];
        list=new ArrayList[n+1];
        
        for(int i=0;i<=n;i++){
            list[i]=new ArrayList<>(); 
        }
        
        for(int i=0;i<paths.length;i++){
            int x=paths[i][0];
            int y=paths[i][1];
            int num=paths[i][2];
            if(gate(x,gates) || summit(y,summits)){
                list[x].add(new pos(y,num));
            }else if(gate(y,gates) || summit(x,summits)){
                list[y].add(new pos(x,num));
            }else{
                list[x].add(new pos(y,num));
                list[y].add(new pos(x,num));
            }
            
        }
        
        dik(n,gates,summits);
        
        
        return answer;
    }
    
    
    public static void dik(int n,int gates[],int summits[]){
        PriorityQueue<pos> pq=new PriorityQueue<>();
        int arr[]=new int[n+1];
        
        Arrays.fill(arr,Integer.MAX_VALUE);
        Arrays.fill(answer,Integer.MAX_VALUE);
        
        for(int i:gates){
            pq.offer(new pos(i,0));
            arr[i]=0;
        }
        
        while(!pq.isEmpty()){
            pos cur=pq.poll();
            
            if(cur.dis>arr[cur.to])continue;
            for(pos x: list[cur.to]){
                int dis=Math.max(arr[cur.to],x.dis);
                
                if(arr[x.to]>dis){
                    arr[x.to]=dis;
                    pq.offer(new pos(x.to,dis));
                }
            }
        }
        Arrays.sort(summits);
        for(int i:summits){
            if(answer[1]>arr[i]){
                answer[0]=i;
                answer[1]=arr[i];
            }
        }
        
    }
    
    public static boolean gate(int n,int gates[]){
        for(int i:gates){
            if(n==i) return true;
        }
        return false;
    }
    
    public static boolean summit(int n,int summits[]){
        for(int i:summits){
            if(n==i) return true;
        }
        return false;
    }
}