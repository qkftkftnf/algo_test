import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        String line[]=s.split("");
        Stack<String> st=new Stack<>();
        
        for(int i=0;i<line.length;i++){
            if(i>0&&!st.isEmpty() && line[i].equals(st.get(st.size()-1))){
                st.pop();
            }else{
                st.push(line[i]);
            }
        }
        if(st.isEmpty())answer=1;


        return answer;
    }
}