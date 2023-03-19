class Solution {
    
    public int solution(int[] a) {
        int arr[]=new int[a.length];
        int answer = 0;
        
        for(int i:a){
            arr[i]++;
        }
        
        
        for(int i=0;i<a.length;i++){
            if(arr[i]==0)continue;
            if(arr[i]<=answer)continue;
            int len=0;
            for(int j=0;j<a.length-1;j++){
                if(a[j]!=i &&a[j+1]!=i)continue;
                if(a[j]==a[j+1])continue;
                len++;
                j++;
            }
            answer=Math.max(len,answer);
        }
        
        return answer*2;
    }
}