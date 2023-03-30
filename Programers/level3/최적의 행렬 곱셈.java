import java.util.Arrays;


//연쇄행렬 최소 곱셈 알고리즘

class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int n=matrix_sizes.length;
        int dp[][]=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        
        int a=0;
        int b=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                a=j;
                b=j+i;
                if(i==0){
                    dp[a][b]=0;
                }else{
                    for(int k=a;k<b;k++){
                        dp[a][b]=Math.min(dp[a][b],dp[a][k]+dp[k+1][b]+matrix_sizes[a][0] * matrix_sizes[k+1][0] * matrix_sizes[b][1]);
                    }
                }
            }
        }
        
        
        return dp[0][n-1];
    }
}