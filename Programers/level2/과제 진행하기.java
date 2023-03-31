import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static class pos {
        String sub;
        int rest;
        
        public pos(String sub,int rest){
            super();
            this.sub=sub;
            this.rest=rest;
        }
    }
    
    public String[] solution(String[][] plans) {
        Stack<pos> st=new Stack();
        String[] answer = new String[plans.length];
        
        
        Arrays.sort(plans,(o1,o2)->{
            return o1[1].compareTo(o2[1]);
        });
        
        int before=0;
        int count=0;
        
        for(int i=0;i<plans.length;i++){
            int time=toTime(plans[i][1]);
            if(before==0) {
                before=time;
            }else{
                int t=time-before;
                while(!st.isEmpty()){
                    pos cur=st.pop();
                    if(cur.rest>t){
                        st.push(new pos(cur.sub,cur.rest-t));
                        break;
                    }else{
                        t-=cur.rest;
                        answer[count++]=cur.sub;
                    }
                }
            }
            st.push(new pos(plans[i][0],Integer.parseInt(plans[i][2])));
            before=time;
        }
        
        while(!st.isEmpty()){
            pos cur=st.pop();
            answer[count++]=cur.sub;
        }
        
        return answer;
    }
    
    public static int toTime(String time){
        int num=0;
        String line[]=time.split(":");
        num+=Integer.parseInt(line[0])*60;
        num+=Integer.parseInt(line[1]);
        return num;
        
        
    }
}