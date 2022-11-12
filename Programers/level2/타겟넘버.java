class Solution {
    public static int answer=0;
    public int solution(int[] numbers, int target) {
        int num=0;
        
        check(0,0,numbers,target);
        
        
        
        
        
        return answer;
        
        
    }
    
    public static void check(int num,int i,int[] ar,int target){
        if(i== ar.length && num==target){
            answer++;
        }
        
        if(i==ar.length) return;
        
        check(num+ar[i],i+1,ar,target);
        check(num-ar[i],i+1,ar,target);
        
    }
}