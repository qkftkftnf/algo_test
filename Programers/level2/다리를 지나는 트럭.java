import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q=new LinkedList<>();
        int total=0;
        
        for(int i=0;i<truck_weights.length;i++){
            int t=truck_weights[i];
            while(true){
                System.out.println(q+" "+answer);
                if(q.isEmpty()){
                    q.offer(t);
                    total+=t;
                    answer++;
                    break;
                }else if(q.size()==bridge_length){
                    total-=q.poll();
                }else{
                    if(total+t<=weight){
                        q.offer(t);
                        total+=t;
                        answer++;
                        break;
                    }else{
                        q.offer(0);
                        answer++;
                    }
                }
            }
        }
        return answer+bridge_length;
    }
}