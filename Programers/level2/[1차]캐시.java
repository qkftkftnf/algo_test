import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list=new LinkedList<>();
        
     
        
        for(int i=0;i<cities.length;i++){
            boolean check=true;
            int num=0;
            for(int j=0;j<list.size();j++){
                if(list.get(j).equals(cities[i].toLowerCase())){
                    check=false;
                    num=j;
                    answer+=1;
                    break;
                }
            }
            list.add(cities[i].toLowerCase());
            if(!list.isEmpty() && list.size()>cacheSize)list.remove(num);
            if(check){
                answer+=5;
            }
        }
        
        
        
        return answer;
    }
}