class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        long arr[]=new long[time(play_time)+1];
        
        for(String str:logs){
            String line[]=str.split("-");
            arr[time(line[0])]+=1;
            arr[time(line[1])]-=1;
        }
        
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
        }
        
        int adv=time(adv_time);
        long max=0;
        for(int i=0;i<adv;i++){
            max+=arr[i];
        }
        
        long num=max;
        int result=0;
        for(int i=0;i<time(play_time)-adv;i++){
            num+=arr[adv+i];
            num-=arr[i];
            if(max<num){
                max=num;
                result=i+1;
            }
        }
        answer=reversetime(result);
        
        
        return answer;
    }
    
    public static int time(String time){
        int num=0;
        String line[]=time.split(":");
        num+=Integer.parseInt(line[0])*3600;
        num+=Integer.parseInt(line[1])*60;
        num+=Integer.parseInt(line[2]);
        return num;
    }
    
    public static String reversetime(int time){
        String result="";
        int h=time/3600;
        time%=3600;
        int m=time/60;
        time%=60;
        result=String.format("%02d:%02d:%02d",h,m,time);
        return result;
        
    }
}