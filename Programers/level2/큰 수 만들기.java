import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> st=new Stack<>();
        String num[]=number.split("");
        int i=0;
        int max=num.length-k;
        while(i<num.length){
            int now=Integer.parseInt(num[i]);
            if(st.isEmpty()){
                st.push(i++);
            }else if(Integer.parseInt(num[st.peek()])<now  && k>0){
                st.pop();
                k--;
            }else{
                st.push(i++);
            }
        }
        for(int j=0;j<max;j++){
            answer+=num[st.get(j)];
        }
        return answer;
    }
}