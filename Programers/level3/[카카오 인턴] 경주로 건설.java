class Solution {
    public static int dx[]={0,1,0,-1};
    public static int dy[]={1,0,-1,0};
    public static int answer;
    public static int arr[][];
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        arr=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                arr[i][j]=Integer.MAX_VALUE;
            }
        }
        dfs(board,new boolean[board.length][board[0].length],0,0,0,-1);
        return arr[board.length-1][board[0].length-1];
    }
    
    public static void dfs(int board[][],boolean visited[][],int x,int y,int cost,int before){
        if(arr[x][y]<cost)return;
        else arr[x][y]=cost;
        
        if(x==board.length-1 &&y==board[x].length-1){
            answer=Math.min(cost,answer);
            return;
        }
        
        
       
        for(int i=0;i<4;i++){
            if((i+2)%4==before) continue;
           int nx=dx[i]+x;
           int ny=dy[i]+y;
           if(nx<board.length  && nx>=0 && ny<board[nx].length && ny>=0 && !visited[nx][ny] && board[nx][ny]==0){
               visited[x][y]=true;
               if(before==-1 || before==i){
                   dfs(board,visited,nx,ny,cost+100,i);
                   visited[x][y]=false;
               }else{
                   dfs(board,visited,nx,ny,cost+600,i);
                   visited[x][y]=false;
               }
           }
       }
        
    }
}