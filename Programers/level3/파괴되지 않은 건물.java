class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int r=board.length;
        int c=board[0].length;
        int n=skill.length;
        
        int sum[][]=new int[r+1][c+1];
        
        
        
        int type=0;
        int sx=0;
        int sy=0;
        int ex=0;
        int ey=0;
        int degree=0;
        for(int i=0;i<n;i++){
            type=skill[i][0];
            sx=skill[i][1];
            sy=skill[i][2];
            ex=skill[i][3];
            ey=skill[i][4];
            degree=skill[i][5];
            
            if(type==1){
                sum[sx][sy]-=degree;
                sum[sx][ey+1]+=degree;
                sum[ex+1][sy]+=degree;
                sum[ex+1][ey+1]-=degree;
            }else{
                sum[sx][sy]+=degree;
                sum[sx][ey+1]-=degree;
                sum[ex+1][sy]-=degree;
                sum[ex+1][ey+1]+=degree;
            }
        }
        
        for(int i=0;i<r+1;i++){
            for(int j=0;j<c;j++){
                sum[i][j+1]+=sum[i][j];
            }
        }
        
        for(int j=0;j<c+1;j++){
            for(int i=0;i<r;i++){
                sum[i+1][j]+=sum[i][j];
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(sum[i][j]+board[i][j]>0)answer++;
            }
        }
        return answer;
    }
}