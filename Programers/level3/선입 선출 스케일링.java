class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        int right=10000*n;
        int left=0;
        
        int time=0;
        int m=0;
        
        
        
        while(right>=left){
            int mid=(left+right)/2;
            
            int num=check(mid,cores);
            
            if(num>=n){
                right=mid-1;
                time=mid;
                m=num;
            }else{
                left=mid+1;
            }
            
        }
        
        m-=n;
        
        for(int i=cores.length-1;i>=0;i--){
            if(time%cores[i]==0){
                if(m==0){
                    answer=i+1;
                    break;
                }
                m--;
            }
        }
        return answer;
    }
    
    
    public static int check(int mid,int cores[]){
        int num=cores.length;
        
        if(mid==0) return num;
        
        
        for(int i:cores){
            num+=(mid/i);
        }
        
        return num;
    }
}