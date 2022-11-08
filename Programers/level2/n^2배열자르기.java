class Solution {
    public int[] solution(int n, long left, long right) {
        int len=(int)(right-left);
        int[] answer = new int[len+1];
        int start=0;
        
        for(long i=left;i<=right;i++){
            long num=(i/n)+1;
            long s=i%n+1;
            
            if(s<=num){
                s=num;
            }
            answer[start++]=(int)s;    
            
        }
        return answer;
    }
}