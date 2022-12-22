import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer,Integer> map=new HashMap();
        HashMap<Integer,Integer> map1=new HashMap();;
        HashMap<Integer,Integer> map2=new HashMap();;
        
        for(int i=0;i<topping.length;i++){
            if(!map1.containsKey(topping[i])){
                map1.put(topping[i],1);
            }else{
                map1.put(topping[i],map1.get(topping[i])+1);
            } 
        }
        
        for(int i=0;i<topping.length;i++){
            if(!map2.containsKey(topping[i])){
                map2.put(topping[i],1);
            }else{
                map2.put(topping[i],map2.get(topping[i])+1); 
            }
            map1.put(topping[i],map1.get(topping[i])-1);
            if(map1.get(topping[i])==0)map1.remove(topping[i]);
            if(map1.size()==map2.size())answer++;
        }
        return answer;
    }
}