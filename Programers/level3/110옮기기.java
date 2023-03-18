import java.util.Stack;
class Solution {    
    public String[] solution(String[] s) {
        
        String[] answer = new String[s.length];
        
        
        for(int j=0;j<s.length;j++){
            Stack<String> st=new Stack<>();
            String line[]=s[j].split("");
            int count=0;
            int IIO=0;
            for(int i=0;i<s[j].length();i++){
                if(line[i].equals("0")){
                    if(st.size()>=2 && st.peek().equals("1") ){
                        st.pop();
                        if(st.peek().equals("1")){
                            st.pop();
                            IIO++;
                        }else{
                            st.push("1");
                            st.push(line[i]);
                            count++;
                        }     
                    }else{
                        st.push(line[i]);
                        count++;
                    }
                }else{
                    st.push(line[i]);
                }
            }
            StringBuilder sb=new StringBuilder();
            
            if(count==0){
                while(IIO>0){
                    IIO--;
                    sb.append("110");
                }
            }
            for(int i=0;i<st.size();i++){
                sb.append(st.get(i));
                if(st.get(i).equals("0"))count--;
                if(count==0){
                    while(IIO>0){
                       IIO--;
                        sb.append("110");
                    }
                }
                
            }
            answer[j]=sb.toString();
        }
        
        
        return answer;
    }
}