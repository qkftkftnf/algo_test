import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        HashMap<String,String> map=new HashMap<>();
        int len=0;
        for(int i=0;i<record.length;i++){
            String line[]=record[i].split(" ");
            if(!line[0].equals("Leave")){
               map.put(line[1],line[2]); 
            } 
            if(!line[0].equals("Change")){
                len++;
            }
        }
        answer=new String[len];
        
        int pos=0;
        for(int i=0;i<record.length;i++){
            String line[]=record[i].split(" ");
            if(line[0].equals("Enter")){
                answer[pos++]=map.get(line[1])+"님이 들어왔습니다.";
            }else if(line[0].equals("Leave")){
                answer[pos++]=map.get(line[1])+"님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}