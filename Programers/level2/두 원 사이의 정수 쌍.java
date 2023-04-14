class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long a=(long)Math.pow(r2,2);
        long b=(long)Math.pow(r1,2);
        
        
        for(int i=1;i<r2;i++){
            int out=(int)Math.sqrt(a-(long)Math.pow(i,2));
            double in=Math.sqrt(b-(long)Math.pow(i,2));
            
            if(in-(int)in==0 && i!=r1) answer++;
            
            answer+=(out-(int)in);
            
        }
        answer=(answer+r2-r1+1)*4;
        return answer;
    }
}