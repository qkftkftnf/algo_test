import java.util.*;

class Solution {
    public static int answer[];
    public int[] solution(int n, long k) {
        answer =new int[n];
        long max=1;
        for(int i=1;i<=n;i++){
            max*=i;
        }
        
        func(n,k,max,0,new boolean[n+1]);
        
        return answer;
    }
    
    public static void func(int n,long k,long max,int pos,boolean visit[]){
        if(k==0)k=max;
        if(n==0) return;
        long num=max/n;
        int count=0;
        for(int i=1;i<visit.length;i++){
            if(visit[i])continue;
            if(count==((k-1)/num)){
                answer[pos]=i;
                visit[i]=true;
                func(n-1,k%num,num,pos+1,visit);
                return;
            }count++;
        }
        
        
    }
}