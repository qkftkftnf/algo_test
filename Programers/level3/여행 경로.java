import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    HashMap<String,Queue<String>> map=new HashMap();
    boolean check=false;
    public static String answer[];
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets,(o1,o2)->{
            return o1[1].compareTo(o2[1]);
        });
        for(int i=0;i<tickets.length;i++){
            Queue<String> q;
            if(!map.containsKey(tickets[i][0])){
                q=new LinkedList<>();
                q.offer(tickets[i][1]);
                map.put(tickets[i][0],q);
            }else{
                q=map.get(tickets[i][0]);
                q.offer(tickets[i][1]);
                map.put(tickets[i][0],q);
            }
        }
        
        answer = new String[tickets.length+1];
        String go="ICN";
        String arr[]=new String[tickets.length+1];
        arr[0]=go;
        dfs(1,go,arr);
        
        return answer;
    }
    
    public  void dfs(int num,String go,String arr[]){
        if(num==arr.length){
            if(!check){
                for(int i=0;i<arr.length;i++){
                    answer[i]=arr[i];
                }
                check=true;
            }
            return;
        }
        if(check) return;
        if(!map.containsKey(go)) return;
        Queue<String> q=map.get(go);
        if(q.isEmpty()) return;
        for(int i=0;i<q.size();i++){
            arr[num]=q.poll();
            dfs(num+1,arr[num],arr);
            q.offer(arr[num]);
        }
    }
}