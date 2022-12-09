import java.util.*;

class Solution {
    public static String answer[];
    public static int max;
    public static LinkedList<String> list=new LinkedList<>();
    public static Queue<String> q=new LinkedList<>();
    public String[] solution(String[] orders, int[] course) {
        answer =new String[4];
        int arr[]=new int[26];
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String total="";
        for(int i=0;i<orders.length;i++){
            for(int j=0;j<orders[i].length();j++){
               if(arr[orders[i].charAt(j)-'A']==0){
                   arr[orders[i].charAt(j)-'A']=1;
               } 
            }
        }
        for(int i=0;i<26;i++){
            if(arr[i]==1){
                total+=(alpha.charAt(i)+"");
            }
        }
        
        for(int i=0;i<course.length;i++){
            max=0;
            find(0,total,course[i],orders,"");
            while(!q.isEmpty()){
                list.add(q.poll());
            }
        }
        
        Collections.sort(list);

        
        answer=new String[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
       
        return answer;
    }
    
    public static void find(int pos,String total, int num, String orders[],String now){
        
        if(now.length()==num){
            int mc=0;
            for(int i=0;i<orders.length;i++){
                int count=0;
                for(int j=0;j<orders[i].length();j++){
                    if(orders[i].charAt(j)==now.charAt(count)){
                        count++;
                        j=-1;
                    }
                    if(count==num){
                        mc++;
                        break;
                    }
                }
            }
            if(mc<2) return;
            if(mc>max){
                q=new LinkedList<>();
                max=mc;
                q.offer(now);
            }else if(mc==max ){
                q.offer(now);
            } 
            return;
        }
        
        if(pos>=total.length()){
            return;
        }
        
        find(pos+1,total,num,orders,now+(total.charAt(pos)+""));
        find(pos+1,total,num,orders,now);
        
    } 
}