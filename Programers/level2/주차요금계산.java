import java.util.*;
    
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<records.length;i++){
            String info[]=records[i].split(" ");
            String time[]=info[0].split(":");
            if(info[2].equals("IN")){
               
                int num=0;
                boolean check=false;
                for(int j=i;j<records.length;j++){
                    String info2[]=records[j].split(" ");
                    if(info2[2].equals("OUT") && info2[1].equals(info[1])){
                        String time2[]=info2[0].split(":");
                        num=cal(time2)-cal(time);
                        check=true;
                        break;
                    }
                }
                
                if(!check)num=((23*60)+59)-cal(time);
                
                if(!map.containsKey(info[1])){
                    map.put(info[1],num);
                }else{
                    map.put(info[1],map.get(info[1])+num);
                }
            } 
        }
        int[] answer = new int[map.size()];
        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        
        int i=0;
        for (String key : keyList) {
            int result=0;
            int num=map.get(key);
            if(num>fees[0]){
                if(((num-fees[0])%fees[2])>0){
                    num+=fees[2];
                }
                    result=fees[1]+ ((num-fees[0])/fees[2])*fees[3];
                }else{
                    result=fees[1];
                }
            answer[i++]=result;
        }
        
        return answer;
    }
    
    public static int cal(String[] time){
        int hour=Integer.parseInt(time[0]);
        int min=Integer.parseInt(time[1]);
        return 60*hour+min;
    }
}