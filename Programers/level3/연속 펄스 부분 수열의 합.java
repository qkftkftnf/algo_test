class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n=sequence.length;
        
        long dp1[]=new long[n];
        long dp2[]=new long[n];
        
        answer=Math.max(DP(n,1,sequence),DP(n,-1,sequence));
        return answer;
    }
    
    public static long DP(int n,int num,int sequence[]){
        long dp[]=new long[n];

        dp[0]=sequence[0]*num;
        long result=dp[0];
        
        for(int i=1;i<n;i++){
            num*=-1;
            dp[i]=Math.max(dp[i-1]+(sequence[i]*num),sequence[i]*num);
            result=Math.max(result,dp[i]);
        }
        
        return result;
        
    }
}