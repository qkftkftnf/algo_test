import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        Stack<Integer> st=new Stack<>();
        while(n>0){
            st.push(n%3);
            n=(n-1)/3;
        }
        while(!st.isEmpty()){
            int num=st.pop();
            if(num==0){
                answer+="4";
               // System.out.print(4);
            }else if(num==1){
                answer+="1";
                //System.out.print(1);
            }else{
                answer+="2";
               // System.out.print(2);
            }
            
        }
        return answer;
    }
}