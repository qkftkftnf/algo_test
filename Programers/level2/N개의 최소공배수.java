class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int num=gcd(arr[0],arr[1]);
        answer=(arr[0]*arr[1])/num;
        
        for(int i=2;i<arr.length;i++){
           num=gcd(answer,arr[i]);
            answer=(answer*arr[i])/num;
        }
        return answer;
    }
    
    
    
    public static int gcd(int a,int b){
        int r=0;
        
        while(b!=0){
            r=a%b;
            a=b;
            b=r;
        }
        return a;
        
    }
}