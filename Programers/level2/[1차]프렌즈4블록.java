import java.util.*;

class Solution {
    public static int dx[]={1,1,0};
    public static int dy[]={0,1,1};
    public static String arr[][];
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int result=-1;
        arr=new String[m][n];
        
        for(int i=0;i<m;i++){
            arr[i]=board[i].split("");
        }
        
        
        while(true){
            result=check(m,n,new boolean[m][n]);
            answer+=result;
            if(result==0){
                break;
            }
            down(m,n);
        }
        
        return answer;
    }
    
    
    
    public static int check(int m, int n,boolean visited[][]){
        int count=0;
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!arr[i][j].equals("0")){
                    int num=0;
                    for(int k=0;k<3;k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];
                        if(nx>=0 && ny>=0 && nx<m && ny<n && arr[i][j].equals(arr[nx][ny])){
                            num++;
                        }
                    }
                    if(num==3){
                        visited[i][j]=true;
                         for(int k=0;k<3;k++){
                            int nx=i+dx[k];
                            int ny=j+dy[k];
                            visited[nx][ny]=true;
                         }
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]) {
                    arr[i][j]="0";
                    count++;
                }
            }
        }
        return count;
    }
    
    
    
    
    public static void down(int m, int n){
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(arr[i][j].equals("0")){
                    int num=i;
                    boolean check=true;
                    while(arr[num][j].equals("0")){
                        num--;
                        if(num<0){
                            check=false;
                            break;
                        }
                    }
                    if(check){
                        arr[i][j]=arr[num][j];
                        arr[num][j]="0";
                    }
                    
                }
            }
        }
    }
}