import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        long num=1;
        long check=0;
        
        Queue<Integer> q=new LinkedList<>();
        
        
        while(n>0){
            q.offer(n%k);
            n/=k;
        }
        
        while(!q.isEmpty()){
            long pp=q.poll();
            
            if(pp!=0){
                check+=(num*pp);
                num*=10;
            }
            if (pp==0 || q.size()==0){ 
                if(check ==0) continue;
                
                int count=0;
                boolean result=false;
                
            
                long max=(long)Math.sqrt(check);
                for(long i=2;i<=max;i++){
                    if(check%i==0){
                        result=true;
                        break;
                    }
                }
                if(!result && check!=1)answer++;
                num=1;
                check=0;
            }
           
        }
        return answer;
    }
}