class Solution {    
    public int solution(String dirs) {
        int answer = 0;
        
        String line[]=dirs.split("");
        int len=line.length;
        
        int arr[][]=new int[11][11];
        boolean visited[][][]=new boolean[11][11][4];
        int dx[]={0,1,0,-1};
        int dy[]={-1,0,1,0};
        
        
        int x=5;
        int y=5;
        
        int nx=0;
        int ny=0;
        int num=0;
        for(int i=0;i<len;i++){
            if(line[i].equals("U")){
                num=0;
            }else if(line[i].equals("R")){
                num=1;
            }else if(line[i].equals("D")){
                num=2;
            }else if(line[i].equals("L")){
                num=3; 
            }
            
            nx=x+dx[num];
            ny=y+dy[num];
            if(nx>=0 && ny>=0 && nx<11 && ny<11){
                int dnum=0;
                if(num>=2){
                    dnum=num-2;
                }else{
                    dnum=num+2;
                }
                if(!visited[nx][ny][num] && !visited[x][y][dnum]){
                    answer++;
                    visited[nx][ny][num]=true;
                }
                x=nx;
                y=ny;
            }
        }
        
       
        
        
        
        return answer;
    }
}