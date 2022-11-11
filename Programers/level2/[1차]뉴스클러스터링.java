import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int n=0;
        int before=0;
        LinkedList<String> st1=new LinkedList<>();
        LinkedList<String> st2=new LinkedList<>();
        
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        
        cal(str1,st1);
        cal(str2,st2);
        
        for(int i=0;i<st1.size();i++){
            for(int j=0;j<st2.size();j++){
                if(st1.get(i).equals(st2.get(j))){
                    n++;
                    st1.remove(i--);
                    st2.remove(j);
                    break;
                }
            }
        }
        
        answer=(int)(((double)n/(st1.size()+st2.size()+n))*65536);
        if(st1.size()==0 && st2.size()==0 && n==0){
            answer=65536;
        }
        
        
        return answer;
    }
    
    public static void cal(String s,LinkedList<String> list){
        String plus="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                plus+=s.charAt(i);
                if(plus.length()==2){
                    list.add(plus);
                    plus="";
                    plus+=s.charAt(i);
                }
            }else{
                plus="";
            }
        }
    }
}