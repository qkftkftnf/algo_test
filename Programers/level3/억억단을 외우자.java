import java.util.Arrays;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        int arr[]=new int[e+1];
        int maxarr[]=new int[e+1];
        
        
        for(int i=1;i<=e;i++){
            for(int j=1;j<=e/i;j++){
                arr[i*j]++;
            }
        }
        
        int num=0;
        int maxnum=0;
        for(int i=e;i>0;i--){
            if(num<=arr[i]){
                num=arr[i];
                maxnum=i;
            }
            maxarr[i]=maxnum;
        }
        
        for(int i=0;i<starts.length;i++){
            answer[i]=maxarr[starts[i]];
        }
        
        return answer;
    }
}