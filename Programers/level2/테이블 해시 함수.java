import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int pos=col-1;
        Arrays.sort(data,(o1,o2) ->{
            if(o1[pos]==o2[pos])return o2[0]-o1[0];
            return o1[pos]-o2[pos];
        });
        
        for(int i=row_begin-1;i<row_end;i++){
            int num=0;
            for(int j=0;j<data[i].length;j++){
                num+=(data[i][j]%(i+1));
            }
            answer=answer ^ num;
        }
        return answer;
    }
}