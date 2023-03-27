class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int len=balls.length;
        int[] answer = new int[len];
        
        int x=0;
        int y=0;
        int num=0;
        
        for(int i=0;i<len;i++){
            if(startX==balls[i][0]){
                if(startY>balls[i][1]){
                    num=2*n-startY-balls[i][1];  
                }else{
                    num=startY+balls[i][1];
                }
                x=Math.min(m-startX,startX);
                y=balls[i][1]-startY;
                answer[i]=(int)Math.pow(2*x,2)+(int)Math.pow(y,2);
                answer[i]=Math.min((int)Math.pow(num,2),answer[i]);
            }else if(startY==balls[i][1]){
                if(startX>balls[i][0]){
                    num=2*m-startX-balls[i][0];  
                }else{
                    num=startX+balls[i][0];
                }
                x=balls[i][0]-startX;
                y=Math.min(n-startY,startY);
                answer[i]=(int)Math.pow(2*y,2)+(int)Math.pow(x,2);
                answer[i]=Math.min((int)Math.pow(num,2),answer[i]);
            }else{
                int t1=(int)Math.pow(startX+balls[i][0],2)+(int)Math.pow(startY-balls[i][1],2);
                int t2=(int)Math.pow(startY+balls[i][1],2)+(int)Math.pow(startX-balls[i][0],2);
                int t3=(int)Math.pow(2*m-balls[i][0]-startX,2)+(int)Math.pow(startY-balls[i][1],2);
                int t4=(int)Math.pow(2*n-balls[i][1]-startY,2)+(int)Math.pow(startX-balls[i][0],2);
                answer[i]=Math.min(Math.min(t1,t2),Math.min(t3,t4));
                
            }
        }
        return answer;
    }
}