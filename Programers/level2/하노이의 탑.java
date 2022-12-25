class Solution {
    public static int answer[][];
    public static int count=0;
    public int[][] solution(int n) {
        int num=(int)Math.pow(2,n)-1;
        answer = new int[num][2];
        
        hanoi(n,1,2,3);
        return answer;
    }
    
    public static void hanoi(int n,int from,int temp,int to){
        if(n==1) {
            answer[count][0]=from;
            answer[count][1]=to;
            count++;
        }
        else{
            hanoi(n-1,from,to,temp);
            answer[count][0]=from;
            answer[count][1]=to;
            count++;
            hanoi(n-1,temp,from,to);
        }
    }
}