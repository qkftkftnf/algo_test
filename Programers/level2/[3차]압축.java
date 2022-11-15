import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        HashMap<String,Integer> map=new HashMap<>();
        LinkedList<Integer> list=new LinkedList<>();
        
        char a='A';
        for(int i=0;i<26;i++){
            map.put(a+"",i+1);
            a+=1;
        }
        
        int start=27;
        for(int i=0;i<msg.length();i++){
            String s="";
            int num=0;
            s+=msg.charAt(i);
            while(map.containsKey(s)){
                num=map.get(s);
                i++;
                if(i>=msg.length()){
                    break;
                }
                s+=msg.charAt(i);
            }
            list.add(num);
            map.put(s,start++);
            i--;   
        }
        answer=new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}