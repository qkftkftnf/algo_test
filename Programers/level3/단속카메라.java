import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int num=-30001;
        Arrays.sort(routes,(o1,o2) -> {
            if(o1[1]==o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });      
        
        for(int i=0;i<routes.length;i++){
            if(num<routes[i][0]){
                num=routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}