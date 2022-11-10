import java.util.*;

class Solution {
    public static class pos{
        int x,y;
        public pos(int x,int y){
            super();
            this.x=x;
            this.y=y;            
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<pos> q=new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++){
            q.offer(new pos(priorities[i],i));
        }

        
        
        while(!q.isEmpty()){
            boolean check=true;
            pos cur=q.poll();
            for(int i=0;i<priorities.length;i++){
                if(priorities[i]>cur.x){
                    check=false;
                    q.offer(cur);
                    break;
                }
            } 
            if(check){
                answer++;
                priorities[cur.y]=-1;
                System.out.print(cur.y);
                if(cur.y==location){
                    break;
                }
            }
              
        }
        
        
        return answer;
    }
}