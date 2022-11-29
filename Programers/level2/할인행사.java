import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<discount.length;i++){
            if(!map.containsKey(discount[i])){
                map.put(discount[i],1);
            }else{
                map.put(discount[i],map.get(discount[i])+1);
            }
            if(i>8){
                boolean check=true;
                for(int j=0;j<want.length;j++){
                    if(!map.containsKey(want[j])|| map.get(want[j])<number[j]){
                        check=false;
                        break;
                    }
                }
                map.put(discount[i-9],map.get(discount[i-9])-1);
                if(check)answer++;
            }
        }
        
        
        return answer;
    }
}