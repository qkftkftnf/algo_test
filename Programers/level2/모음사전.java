import java.util.*;
class Solution {
    public int solution(String word) {
        int rule[]={781,156,31,6,1};
        HashMap<String,Integer> map=new HashMap();
        int answer=word.length();
        map.put("A",0);
        map.put("E",1);
        map.put("I",2);
        map.put("O",3);
        map.put("U",4);
        
        for(int i=0;i<word.length();i++){
            String line=word.charAt(i)+"";
            answer+=map.get(line)*rule[i];
        }
        
        return answer;
    }
}