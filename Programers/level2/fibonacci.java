class Solution {
    public static int dp[];
    public int solution(int n) {
        dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        int answer = fib(n);
        return answer;
    }
    
    public static int fib(int n){
        if(n==0||dp[n]!=0){
            return dp[n];
        }
        else{
            int num=fib(n-1)+fib(n-2);
            dp[n]=num%1234567;
            return dp[n];
        }
    }
}