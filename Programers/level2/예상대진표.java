class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

       while(a!=b){
           a=cal(a);
           b=cal(b);
           answer++;
       }

        return answer;
    }
    
    public static int cal(int num){
        if(num%2==1){
            return num/2+1;
        }else{
            return num/2;
        }
    }
}