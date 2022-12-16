import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        
        long s1=0,s2=0,sum=0;
        
        for(int i=0;i<queue1.length;i++){
            q1.offer(queue1[i]);
            s1+=queue1[i];
        }
        
        for(int i=0;i<queue2.length;i++){
            q2.offer(queue2[i]);
            s2+=queue2[i];
        }
        
        sum=s1+s2;
        if(sum%2!=0) return -1;
        sum/=2;
        
        int num=0;
        
        while(num<queue1.length*4){
            if(s1==s2)return num;
            
            if(s2>s1){
                s1+=q2.peek();
                s2-=q2.peek();
                q1.offer(q2.poll());
            }else{
                s2+=q1.peek();
                s1-=q1.peek();
                q2.offer(q1.poll());
            }
            num++;
        }
        
        return answer;
    }
}