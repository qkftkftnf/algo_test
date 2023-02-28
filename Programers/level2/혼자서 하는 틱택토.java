class Solution {
    public int solution(String[] board) {
        int answer = 1;
        String arr[][]=new String[3][3];
        
        int[][] c={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        
        boolean O=false;
        boolean X=false;
        
        int f=0;
        int s=0;
        
        
        for(int i=0;i<board.length;i++){
            String line[]=board[i].split("");
            for(int j=0;j<line.length;j++){
                arr[i][j]=line[j];
                if(line[j].equals("O")){
                    f++;    
                }else if(line[j].equals("X")){
                    s++;
                }
            }
        }
        
        String str="";
        int num=f-s;
        if(num==0 || num==1){
             for(int i=0;i<c.length;i++){
                for(int j=0;j<3;j++){
                    int x=c[i][j]/3;
                    int y=c[i][j]%3;
                    if(j==0){
                        str=arr[x][y];
                    }else{
                        if(!str.equals(arr[x][y])){
                            break;
                        }else {
                            if(j==2){
                                if(str.equals("O")) O=true;
                                else if(str.equals("X")) X=true;
                            }
                        }
                    }
                }
             }
            if(O && X) return 0;
            else if((num==1 && O) || (num==0 && X) || (!O && !X)) return answer;   
        }
        
        return 0;
        
    }
}