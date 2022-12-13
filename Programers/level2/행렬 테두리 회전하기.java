class Solution {
    public static int dx[]={0,1,0,-1};
    public static int dy[]={1,0,-1,0};
    public static int arr[][];
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr=new int[rows+1][columns+1];
        
        int num=1;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                arr[i][j]=num++;
            }
        }
        for(int i=0;i<queries.length;i++){
            answer[i]=turn(queries[i]);
        }
        
        
        return answer;
    }
    
    public static int turn(int queries[]){
        int result=100001;
        int sx=queries[0];
        int sy=queries[1];
        int ex=queries[2];
        int ey=queries[3];
        int nx=sx;
        int ny=sy;
        int i=0;
        int temp=arr[nx][ny];
        int temp2=0;
        while(i<4){
            result=Math.min(result,temp);
            nx+=dx[i];
            ny+=dy[i];
            if(nx>ex || ny>ey || nx<sx || ny<sy){
                nx-=dx[i];
                ny-=dy[i];
                i++;
                continue;
            }
            temp2=arr[nx][ny];
            arr[nx][ny]=temp;
            temp=temp2;
        }
        
        return result;
    }
}