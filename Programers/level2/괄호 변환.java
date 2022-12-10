import java.util.*;

class Solution {
    public static String answer="";
    public static Stack<String> st;
    public String solution(String p) {
        
        if(check(p)) return p;
        else{
            answer=dfs(p);
        }
        return answer;
    }
    
    
    public static boolean check(String p){
        int num=0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){
                num++;
            }else{
                num--;
            }
            
            if(num<0)return false;
        }
        return true;
    }
    
    public static String dfs(String p){
        if(p.equals(""))return"";
        int num=0;
        String u="";
        String v="";
        int i=0;
        for(;i<p.length();i++){
            if(p.charAt(i)=='('){
                num++;
            }else{
                num--;
            }
            u+=(p.charAt(i)+"");
            if(num==0) break;
        }
        u=p.substring(0,i+1);
        v=p.substring(i+1,p.length());
        
        if(check(u)) {
            u+=dfs(v);
            return u;
        }else{
            String pp="(";
            pp+=dfs(v);
            pp+=")";
            for(int j=1;j<u.length()-1;j++){
                if(u.charAt(j)=='('){
                    pp+=")";
                }else{
                    pp+="(";
                }
            }
            return pp;
            
        }
        
    }
}