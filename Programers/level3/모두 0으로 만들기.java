import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    public static ArrayList<Integer> list[];
    public static HashMap<Integer,Integer> map;
    public long solution(int[] a, int[][] edges) {
        long answer = -1;
        
        long check=0;
        for(int i=0;i<a.length;i++){
            check+=a[i];
        }
        if(check!=0) return answer;
        else{
            answer=0;
            list=new ArrayList[a.length+1];
            map= new HashMap<>();
            
            long arr[]=new long[a.length];
            
            
            for(int i=0;i<=a.length;i++){
                list[i]=new ArrayList<>();
            }
            for(int i=0;i<a.length;i++){
                arr[i]=a[i];
            }
            
            for(int i=0;i<edges.length;i++){
                list[edges[i][0]].add(edges[i][1]); 
                list[edges[i][1]].add(edges[i][0]);
                for(int j=0;j<2;j++){
                    if(!map.containsKey(edges[i][j])){
                        map.put(edges[i][j],1);
                    }else{
                        map.put(edges[i][j],map.get(edges[i][j])+1);
                    }
                }
            }
            
            Queue<Integer> q=new LinkedList<>();
            
            for(int i:map.keySet()){
                if(map.get(i)==1){
                    q.offer(i);
                }
            }
            
            while(!q.isEmpty()){
                int num=q.poll();
                for(int i:list[num]){
                    if(map.get(i)>0){
                        map.put(num,0);
                        answer+=Math.abs(arr[num]);
                        arr[i]+=arr[num];
                        arr[num]-=arr[num];
                        map.put(i,map.get(i)-1);
                        if(map.get(i)==1){
                            q.offer(i);
                        }
                        break;
                    }
                }
                map.put(num,0);
            }
           
            
        }
        return answer;
    }
}