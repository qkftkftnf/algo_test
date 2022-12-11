import java.util.*;

class Solution {
    public static String y[]={"+","-","*"};
    public static long res=0;
    public long solution(String expression) {
        long answer = 0;
        int len=0;
        
        boolean check[]=new boolean[3];
        for(int i=0;i<expression.length();i++){
            
            if(expression.charAt(i)=='+' && !check[0]){
                len++;
                check[0]=true;
            }else if(expression.charAt(i)=='-' && !check[1]){
                len++;
                check[1]=true;
            }else if(expression.charAt(i)=='*' && !check[2]){
                len++;
                check[2]=true;
            }
        }
        
        calc(expression,check,new boolean[3],len,"");
        answer=res;
        return answer;
    }
    
    public static void calc(String expression,boolean[] check, boolean[] visited,int count,String seq){
        if(count==seq.length()){
            
            String vi=go(expression,count,seq,0);
            long result=Long.parseLong(vi);
            res=Math.max(Math.abs(result),res);
        }
        
        for(int i=0;i<3;i++){
            if(visited[i] || !check[i])continue;
            visited[i]=true;
            calc(expression,check,visited,count,seq+y[i]);
            visited[i]=false;
        }
    }
    
    public static String go(String expression,int count,String seq,int now){
        Stack<String> st=new Stack<>();
        if(now==count)return expression; 
        
        String num="";
            for(int i=0;i<expression.length();i++){
                boolean mm=false;
                for(int j=0;j<count;j++){
                    if(expression.charAt(i)==seq.charAt(j) && i>0){
                        mm=true;
                        for(int k=0;k<count;k++){
                            if(expression.charAt(i-1)==seq.charAt(k)) mm=false;
                        }
                    }
                }
                if(!mm)num+=(expression.charAt(i)+"");
                else{
                    if(st.isEmpty()){
                       st.push(num); 
                       st.push(expression.charAt(i)+"");
                    }else if((st.peek()).equals(seq.charAt(now)+"")){
                        String ss=st.pop();
                        String bnum=st.pop();
                        long result=0;
                        if(ss.equals("+")){
                            result=Long.parseLong(bnum)+Long.parseLong(num);
                        }else if(ss.equals("-")){
                            result=Long.parseLong(bnum)-Long.parseLong(num);
                        }else{
                            result=Long.parseLong(bnum)*Long.parseLong(num);
                        }
                        st.push(Long.toString(result));
                        st.push(expression.charAt(i)+"");
                    }else{
                        st.push(num); 
                        st.push(expression.charAt(i)+"");
                    }
                    num="";
                } 
            }
            if((st.get(st.size()-1)).equals(seq.charAt(now)+"")){
                 String ss=st.pop();
                        String bnum=st.pop();
                        long result=0;
                        if(ss.equals("+")){
                            result=Long.parseLong(bnum)+Long.parseLong(num);
                        }else if(ss.equals("-")){
                            result=Long.parseLong(bnum)-Long.parseLong(num);
                        }else{
                            result=Long.parseLong(bnum)*Long.parseLong(num);
                        }
                        st.push(Long.toString(result));
            }else{
                st.push(num);
            }
            expression="";
            for(int i=0;i<st.size();i++){
                expression+=st.get(i);
            }
            return go(expression,count,seq,now+1);
    }
}