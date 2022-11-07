import java.util.*;

class Solution {
    public static LinkedList<Integer> list=new LinkedList<>();
    public int solution(String[][] clothes) {
        int answer = 1;
        int len=clothes.length;
        HashMap<String,Integer> map=new HashMap();
        for(int i=0;i<len;i++){
            if(!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],1);
            }else{
                int num=map.get(clothes[i][1]);
                map.put(clothes[i][1],num+1);
            }
        }
        
        Set<String> key=map.keySet();
        
        
        for(String i:key){
            System.out.println(map.get(i));
            answer*=(map.get(i)+1);
        }
        
        return answer-1;
    }
    
   
}