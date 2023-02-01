import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> set=new HashSet<>();
        HashMap<String,Integer> map=new HashMap<>();
        
        
        int j=0;
        for(String s:gems){
            set.add(s);
        }
        
        
        for(int i=0;i<gems.length;i++){
            if(!map.containsKey(gems[i])){
                map.put(gems[i],1);
            }else{
                map.put(gems[i],map.get(gems[i])+1);
            }
            
            while(map.size()==set.size()){
                if((answer[0]==0 && answer[1]==0) || answer[1]-answer[0]>i-j){
                    answer[0]=j+1;
                    answer[1]=i+1;
                }
                
                map.put(gems[j],map.get(gems[j])-1);
                
                if(map.get(gems[j])==0){
                    map.remove(gems[j]);
                }
                j++;
                
            }
        }
        
        
        
        
        return answer;
    }
}