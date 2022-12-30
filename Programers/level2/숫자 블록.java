class Solution {
    public int[] solution(long begin, long end) {
        int len=(int)(end-begin);
        int[] answer = new int[len+1];
        
        for(int i=0;i<=len;i++){
            
            int num=(int)Math.sqrt(i+begin);
            boolean c=true;
            for(int j=2;j<=num;j++){
                if((i+begin)%j==0 && (i+begin)/j<=10000000 ) {
                    answer[i]=(int)(i+begin)/j;
                    c=false;
                    break;
                }
            }
            if(c && i+begin>1)answer[i]=1;
        }
        return answer;
    }
}