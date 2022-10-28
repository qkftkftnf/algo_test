
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int s=n;
        int num=0;
        while(s>0){
            if(s%2==1)num++;
            s/=2;
        }
        
        while(true){
            int ss=++n;
            int plz=0;
            while(ss>0){
                if(ss%2==1)plz++;
                ss/=2;
            }
            if(plz==num){
                answer=n;
                break;
            }
        }
        
        return answer;
    }
}