class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod=1000000007;
        int dp[][]=new int[n][m];
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]-1][puddles[i][0]-1]=-1;
        }
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            if(dp[i][0]!=-1)dp[i][0]=dp[i-1][0];
        }
        for(int i=1;i<m;i++){
            if(dp[0][i]!=-1)dp[0][i]=dp[0][i-1];
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j]==-1 ) continue;
                dp[i][j]=(Math.max(dp[i-1][j],0)+Math.max(dp[i][j-1],0))%mod;
            }
        }
        
        answer=dp[n-1][m-1];
        
        return answer;
    }
}