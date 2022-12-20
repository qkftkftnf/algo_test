class Solution {
    public static int dx[]={1,0,-1,0};
    public static int dy[]={0,-1,0,1};
    public int[] solution(String[][] places) {
        int len=places.length;
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++){
            int num=1;
            String arr[][]=new String[len][len];
            for(int j=0;j<len;j++){
                arr[j]=places[i][j].split("");
            }
            loop:
            for(int x=0;x<len;x++){
                for(int y=0;y<len;y++){
                    if(arr[x][y].equals("O") || arr[x][y].equals("P")){
                        int count=0;
                        if(arr[x][y].equals("P"))count++;
                        for(int k=0;k<4;k++){
                            int nx=x+dx[k];
                            int ny=y+dy[k];
                            if(nx>=0 && ny>=0 && nx<len && ny<len){
                                if(arr[nx][ny].equals("P")) count++;
                            }
                        }
                      if(count>1){
                          num=0;
                          break loop;
                      }
                    }
                }
            }
            answer[i]=num;
        }
        
        return answer;
    }
}
