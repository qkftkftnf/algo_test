class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min=1;
        int max=200000000;
        
        while(min<=max){
             
            int mid=(min+max)/2;
            
            if(cross(stones,k,mid)){
                System.out.println(min+" "+max);    
                min=mid+1;
                answer=mid;
            }else{
                max=mid-1;
            }
        }

        return answer;
    }
    
    public static boolean cross(int stones[],int k,int mid){
        int count=0;
        
        for(int i=0;i<stones.length;i++){
            if(stones[i]-mid<0) count++;
            else count=0;
            
            if (count==k) return false;
        }
        return true;
    }
        
}