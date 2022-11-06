import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        int X=s.length();
        String ar[]=s.split("");
        Stack<Character> st=new Stack();
        
        for(int i=0;i<ar.length;i++){
            boolean check=true; 
            for(int j=0;j<X;j++){
                int k=(j+i)%X;
                if(s.charAt(k)=='('|| s.charAt(k)=='{' || s.charAt(k)=='['){
                    st.push(s.charAt(k));
                }
                if(st.isEmpty()){
                    check=false;
                    break;
                }
                else if(s.charAt(k)==')'){
                    if(st.peek()==('(')){
                        st.pop();      
                    }else{
                        check=false;
                    }
                }else if(s.charAt(k)=='}'){
                    if(st.peek()==('{')){
                        st.pop();      
                    }else{
                        check=false;
                        break;
                    }
                }else if(s.charAt(k)==']'){
                    if(st.peek()==('[')){
                        st.pop();      
                    }else{
                        check=false;
                        break;
                    }
                }
            }
            
            if(check && st.isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}