import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day=1;
        int num=0;
        int check=0;
        int count=1;
        Queue<Integer> q=new LinkedList<>();
        LinkedList<Integer> list=new LinkedList<>();
        
    
        
        for(int i=0;i<progresses.length;i++){
            num=progresses[i];
            while(true){
                if(num+(day*speeds[i])>=100){
                    q.offer(day);
                    break;
                }
                day++;
            }
        }
        
        while(true){
            num=q.poll();
            if(q.isEmpty()){
                list.add(count);
                break;
            }
            check=q.peek();
            if(num!=check){
                list.add(count);
                count=1;
            }else{
                count++;
            }
        }
        int answer[]=new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        
        return answer;
    }
}