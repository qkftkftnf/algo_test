class Solution {
    public int solution(int n) {
        int answer = 0;
        int INF=1000000007;
        long dp[]=new long[n+1];
        dp[0]=1;
        dp[2]=3;
        dp[4]=11;
        
        if(n%2!=0)return 0;
        else{
            for(int i=4;i<=n;i+=2){
                dp[i]=(4*dp[i-2]%INF-dp[i-4]%INF+INF)%INF;
            }
        }
        answer=(int)dp[n];
        return answer;
    }
}