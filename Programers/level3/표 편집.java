import java.util.Stack;

class Solution {

    public static Stack<Integer> st=new Stack();
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        
        for(int i=0;i<cmd.length;i++){
            String line[]=cmd[i].split(" ");
            if(cmd[i].charAt(0)=='D'){
                k+=Integer.parseInt(line[1]);
                if(k>=n)k=n;
            }else if(cmd[i].charAt(0)=='U'){
                k-=Integer.parseInt(line[1]);
                if(k<0)k=0;
            }else if(cmd[i].charAt(0)=='C'){
                st.push(k);
                n--;
                if(k==n)k-=1;
            }else{
                if(k>=st.pop())k++;
                n++; 
            }
        }

        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<n;i++){
            sb.append("O");
        }
        while(!st.isEmpty()){
            sb.insert(st.pop(),"X");
        }
        
        return sb.toString();
    }
}