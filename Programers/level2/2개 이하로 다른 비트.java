class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            long num=numbers[i];
            String ma=Long.toBinaryString(num);
            int count=0;
            boolean all=true;
            for(int j=0;j<ma.length();j++){
                if(ma.charAt(j)=='0'){
                    all=false;
                    count=ma.length()-j-1;
                }
            }
            
            if(all)count=ma.length();
            long nn=(long)Math.pow(2,count);
            
            num=num|nn;
            num-=(nn/2);
            answer[i]=num;
            }
        
        return answer;
    }
}