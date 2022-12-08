class Solution {
    public int dx[]={1,0,-1};
    public int dy[]={0,1,-1};
    public int[] solution(int n) {
        int len=0;
        for(int i=1;i<=n;i++){
            len+=i;
        }
        int[] answer = new int[len];
        int arr[][]=new int[n][n];
        
        int x=0;
        int y=0;
        arr[x][y]=1;
        int move=0;
        for(int i=1;i<len;i++){
            int nx=x+dx[move%3];
            int ny=y+dy[move%3];
            if(nx>=0 && ny>=0 && nx<n && ny<n &&arr[nx][ny]==0){
                arr[nx][ny]=i+1;
                x=nx;
                y=ny;
            }else{
                i--;
                move++;
            }
        }
        
        int num=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]!=0)answer[num++]=arr[i][j];
            }
        }
        
        
        
        
        return answer;
    }
}