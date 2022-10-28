class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total=brown+yellow;
        int n=(int)Math.sqrt(yellow);
        
        while(true){
            if(yellow%n==0){
                int a=yellow/n;
                if(((n+2)*(a+2))!=total){
                    n++;
                    continue;
                }
                if(n>a){
                    answer[0]=n+2;
                    answer[1]=a+2;
                    break;
                }else{
                    answer[0]=a+2;
                    answer[1]=n+2;
                    break;
                }
            }n++;
        }
        
        return answer;
    }
}