import java.util.Stack;
class Solution {
    public int solution(int n, long l, long r) {
        return count(r)-count(l-1);
    }
    
    public static int count(long num){
        long result=0;
        
        if(num<=5){
            if(num>=3) return (int)num-1;
            else return (int)num;
        }
        
        int n=1;
        while((long)Math.pow(5,n+1)<num){
            n++;
        }
        long mod=(long)Math.pow(5,n);
        
        int m=(int)(num/mod);
        long s=num%mod;
        
        result=(long)(m*(int)Math.pow(4,n));
        
        if(m>=3){
            result-=(long)Math.pow(4,n);
        }
        
        if(m==2){
            return (int)result;
        }
        else{
            return (int)result+count(s);
        }
        
    }
}