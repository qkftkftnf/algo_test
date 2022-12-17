class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int n=board.length;
        int k=board[0].length;
        
        int dp[][]=new int[n][k];
        
        for(int i=0;i<n;i++){
            dp[i][0]=board[i][0];
            answer=Math.max(answer,dp[i][0]);
        }
        for(int i=0;i<k;i++){
            dp[0][i]=board[0][i];
            answer=Math.max(answer,dp[0][i]);
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<k;j++){
                if(board[i][j]==0)continue;
                int count=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                dp[i][j]=count+1;
                answer=Math.max(answer,dp[i][j]);
            }
        }
        

        return answer*answer;
    }
    
}