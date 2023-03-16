import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int n=scores[0][0];
        int m=scores[0][1];
        int sum=n+m;
        
        
        Arrays.sort(scores,(o1,o2)->{
            if(o2[0]==o1[0]) return o1[1]-o2[1];
           return o2[0]-o1[0]; 
        });
        int maxn=scores[0][0];
        int maxm=0;
        
        for(int i=0;i<scores.length;i++){
            if(scores[i][0]>n && scores[i][1]>m)return -1;
            if(scores[i][0]==maxn){
                maxm=scores[i][1];
                if(scores[i][1]+scores[i][0]>sum){
                    answer++;
                }
            }else{
                if(scores[i][1]>=maxm){
                    maxm=scores[i][1];
                    if(scores[i][1]+scores[i][0]>sum){
                        answer++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}