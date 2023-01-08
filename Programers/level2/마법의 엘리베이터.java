class Solution {
        
    public static int answer=0;
    
    public int solution(int storey) {
        answer = Integer.MAX_VALUE;
        
        check(storey,0);
        
        return answer;
    }
    
    public static void check(int storey,int num){
        if(storey==0){
            answer=Math.min(num,answer);
            return;
        }
        int count=storey%10;
        int next=storey/10;
        check(next,num+count);
        if(next!=0){
            next++;
        }else{
            num++;
        }
        check(next,num+10-count);
    }
}