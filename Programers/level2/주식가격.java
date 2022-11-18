import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<prices.length;i++){
            if(st.isEmpty() || prices[st.peek()]<=prices[i]){
                st.push(i);
            }else{
                while(prices[st.peek()]>prices[i]){
                    int count=st.pop();
                    answer[count]=i-count;
                    if(st.isEmpty()){
                        break;
                    }
                }
                st.push(i);
            }  
        }
        
        while(!st.isEmpty()){
            int num=st.pop();
            System.out.println(num);
            answer[num]=prices.length-num-1;
        }
        return answer;
    }
}