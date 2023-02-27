import java.util.Arrays;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int dp[]=new int[n+1];
        int div=1000000007;
        
        Arrays.sort(money);
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i%money[0]==0)dp[i]=1;
        }
        
        for(int i=1;i<money.length;i++){
            for(int j=money[i];j<=n;j++){
                dp[j]=(dp[j]+dp[j-money[i]])%div;
            }
        }
        
        
        return dp[n];
    }
}