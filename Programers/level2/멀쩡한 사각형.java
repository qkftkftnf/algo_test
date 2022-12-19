class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int temp=0;
        if(w>h)temp=w;
        else temp=h;
        if(w==h)return (long)w*(long)h-w;
        
        long num=gcd(w,h);
        answer=(long)w*(long)h- ((w+h)-num);
        
        
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