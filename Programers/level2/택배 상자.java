import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n=order.length;
        
        Stack<Integer> st=new Stack();
        
        int num=1;
        int i=0;
        
        while(true){
            if(!st.isEmpty()){
                if(order[i]==st.peek()){
                    answer++;
                    st.pop();
                    i++;
                    continue;
                }
            }
            if(num>n)break;
            
            if(order[i]!=num){
                st.push(num);
            }else{
                i++;
                answer++;
            }
            num++;
        }
        
        
        return answer;
    }
}