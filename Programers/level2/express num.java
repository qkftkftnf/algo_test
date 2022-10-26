class Solution {
    public int solution(int n) {
        int answer = 0;
        int j=1;
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
            if(sum>=n){
                while(sum>n){
                    sum-=j++;
                }
                if(sum==n)answer++;
            }
        }
        return answer;
    }
}