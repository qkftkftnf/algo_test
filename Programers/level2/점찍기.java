class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        

        
        long max=(long)Math.pow(d,2);

        for(int i=0;i<=d;i+=k){
            long x=(long)Math.pow(i,2);
            int y=(int)Math.sqrt(max-x);
            answer+=(y/k+1);
        }
        
        
        return answer;
    }
}