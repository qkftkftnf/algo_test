class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int dp[][]=new int[target+1][2];
        
        for(int i=1;i<=target;i++){
            dp[i][0]=Integer.MAX_VALUE;
        }
        
        
        for(int i=1;i<=20;i++){
            if(i<=target){
                dp[i][0]=1;
                dp[i][1]=1;
            }if(i*2<=target){
                dp[i*2][0]=1;
                dp[i*2][1]=0;
            }if(i*3<=target){
                dp[i*3][0]=1;
                dp[i*3][1]=0;
            }
        }
        
        if(target>=50){
            dp[50][0]=1;
            dp[50][1]=1;
        }
        
        
        for(int i=2;i<=60;i++){
            if(i>target)continue;
            for(int j=1;j<i;j++){
                if(dp[i][0]>dp[i-j][0]+dp[j][0]){
                    dp[i][0]=dp[i-j][0]+dp[j][0];
                    dp[i][1]=dp[i-j][1]+dp[j][1];
                }else if(dp[i][0]==dp[i-j][0]+dp[j][0]){
                    dp[i][1]=Math.max(dp[i][1],dp[i-j][1]+dp[j][1]);
                }
            }
        }
        
        for(int i=61;i<=target;i++){
            for(int j=1;j<=60;j++){
                if(dp[i][0]>dp[i-j][0]+dp[j][0]){
                    dp[i][0]=dp[i-j][0]+dp[j][0];
                    dp[i][1]=dp[i-j][1]+dp[j][1];
                }else if(dp[i][0]==dp[i-j][0]+dp[j][0]){
                    dp[i][1]=Math.max(dp[i][1],dp[i-j][1]+dp[j][1]);
                }
            }
        }
        
        
        answer[0]=dp[target][0];
        answer[1]=dp[target][1];
        
        
        
        
        
        
        return answer;
    }
}