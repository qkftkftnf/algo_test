class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        
        int start=0;
        int end=0;
        for(int i=0;i<stations.length;i++){
            end=stations[i]-w-1;
            answer+=cal(start,end,w);
            start=stations[i]+w;
        }
        end=n;
        answer+=cal(start,end,w);
        

        return answer;
    }
    
    public static int cal(int start,int end,int w){  
        int num=0;
        int len=2*w+1;
        num=end-start;
        if(num>0)return ((num-1)/len+1);
        return 0;
    }
}