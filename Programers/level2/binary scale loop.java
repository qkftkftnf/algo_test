class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        String num=s;
        
        while(!num.equals("1")){
            answer[0]++;
            int len=num.length();
            int count=0;
            for(int i=0;i<len;i++){
                if(num.charAt(i)=='0'){
                    count++;
                }
            }
            answer[1]+=count;
            int check=len-count;
            num="";
            while(true){
                if(check==1){
                    num+=1;
                    break;
                }
                num+=(check%2);
                check/=2;
            }
        }
        
        return answer;
    }
}