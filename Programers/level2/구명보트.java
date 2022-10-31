import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int min=0;
        for(int i=people.length-1;i>=0;i--){
            if(i<min)break;
            answer++;
            if(people[min]+people[i]<=limit){
                min++;
            }
        }
        
        return answer;
    }
}