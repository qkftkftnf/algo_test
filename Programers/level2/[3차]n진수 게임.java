class Solution {
    // n= 진법 t= 미리 구할 숫자의 갯수, m= 게임 참가 인원, p= 튜브의 순서
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder answer=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;sb.length()<=t*m;i++){
            sb.append(Integer.toString(i,n));
        }
        
        for(int i = p - 1;answer.length() < t; i += m){
            answer.append(sb.charAt(i));
        }
        
        return answer.toString().toUpperCase();
    }
}