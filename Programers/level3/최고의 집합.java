import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        if(s>=n){
            answer=new int [n];
            Arrays.fill(answer,s/n);
            int num=s%n;
            for(int i=1;i<=num;i++){
                answer[n-i]++;
            }
            
        }
        return answer;
    }
}