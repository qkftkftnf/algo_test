class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        boolean arr[]=new boolean[n+1];
        
        for(int i=0;i<section.length;i++){
            arr[section[i]]=true;
        }
        
        for(int i=1;i<=n;i++){
            if(arr[i]){
                answer++;
                i+=(m-1);
            }
        }
        
        
        return answer;
        
    }
}