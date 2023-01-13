import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    
    public static class pos implements Comparable<pos>{
        int x,num;
        
        public pos(int x,int num){
            super();
            this.x=x;
            this.num=num;
        }
        
        public int compareTo(pos e){
            return e.num-this.num;
        }
    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        PriorityQueue<pos> de=new PriorityQueue<>();
        PriorityQueue<pos> pi=new PriorityQueue<>();
        long answer = 0;
        
        boolean check=false;

        for(int i=n-1;i>=0;i--){
            if(deliveries[i]!=0){
                de.offer(new pos(deliveries[i],i));
            }
            if(pickups[i]!=0 ){
                pi.offer(new pos(pickups[i],i));
            }
        }
        
        while(!check){
            int num1=0;
            int num2=0;
            if(!de.isEmpty())num1=de.peek().num+1;
            if(!pi.isEmpty())num2=pi.peek().num+1;
            
            int num=Math.max(num1 , num2);
            int go=cap;
            int back=cap;
            
            
            while(go>0 && !de.isEmpty()){
                pos del=de.poll();
                if(del.x>go){
                    de.offer(new pos(del.x-go,del.num));
                    go=0;
                }else{
                    go-=del.x;
                }
            }
            
            while(back>0 && !pi.isEmpty()){
                 pos pick=pi.poll();
                if(pick.x>back){
                    pi.offer(new pos(pick.x-back,pick.num));
                    back=0;
                }else{
                    back-=pick.x;
                }
            }
            
            
            
            if(num==0)check=true;
            else answer+=(num*2);
        }
        
        return answer;
    }
}