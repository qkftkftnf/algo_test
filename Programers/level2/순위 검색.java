import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        HashMap<String,ArrayList<Integer>> map=new HashMap<>();
        
        for(String i: info){
            String [] data=i.split(" ");
            String languages[]={data[0],"-"};
            String jobs[]={data[1],"-"};
            String exps[]={data[2],"-"};
            String foods[]={data[3],"-"};
            int value=Integer.parseInt(data[4]);
            for(String l: languages){
                for(String j: jobs){
                    for(String e: exps){
                        for(String f: foods){
                            String k=l+" "+j+" "+e+" "+f;
                            if(!map.containsKey(k)){
                                ArrayList<Integer> list=new ArrayList<>();
                                list.add(value);
                                map.put(k,list);
                            }else {
                                ArrayList<Integer> list=map.get(k);
                                list.add(value);
                                map.put(k,list);
                            }
                        }
                    }
                }
            }
        }
        
        int[] answer = new int[query.length];
        
        for(String s: map.keySet()){
            ArrayList<Integer>list=map.get(s);
            Collections.sort(list);
            map.put(s,list);
        }
        
        int count=0;
        for(String s: query){
            s=s.replaceAll("and ","");
            String line[]=s.split(" ");
            String key=line[0]+" "+line[1]+" "+line[2]+" "+line[3];
            if(map.containsKey(key)){
                ArrayList<Integer> list=map.get(key);
                int left=0;
                int right=list.size();
                while(left<right){
                    int mid=(left+right)/2;
                    if(list.get(mid)>=Integer.parseInt(line[4]))
                        right=mid;
                    else
                        left=mid+1;
                }
                answer[count]=list.size()-left;
            }
            count++;
        }
        return answer;
    }
}