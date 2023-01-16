import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    public static int dx[]={0,1,0,-1};
    public static int dy[]={-1,0,1,0};   //상,우,하,좌
    public static boolean visited[][][];
    public int[] solution(String[] grid) {
        ArrayList<Integer> list=new ArrayList<>();
       
        
        visited=new boolean[grid.length][grid[0].length()][4];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length();j++){
                for(int k=0;k<4;k++){
                    if(!visited[i][j][k]){
                        list.add(find(grid,i,j,k));     
                    }
                }
            }
        }
        int answer[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public static int find(String grid[],int i,int j,int k){
        int num=0;
        
        while(true){
            if(visited[i][j][k]) break;
            
            num++;
            visited[i][j][k]=true;
            if(grid[i].charAt(j)=='L'){
                k=(k+3)%4;
            }else if(grid[i].charAt(j)=='R'){
                k=(k+1)%4;
            }
            
            i=(i+dx[k]+grid.length)%grid.length;
            j=(j+dy[k]+grid[0].length())%grid[0].length();
            
            
        }
        return num;
    }
}