class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m=key.length;
        int n=lock.length;
        int len=2*m+n-2;
        int arr[][]=new int[len][len];
        
        for(int i=m-1;i<m+n-1;i++){
            for(int j=m-1;j<m+n-1;j++){
                arr[i][j]=lock[i-m+1][j-m+1];
            }
        }
        for(int i=0;i<4;i++){
            if(check(arr,key,m,n)) return true;
            key=rotate(key);
        }
        
        return false;
    }
    
    public static boolean check(int arr[][],int key[][],int m,int n){
        int len=arr.length;
        
        for(int i=0;i<len-m+1;i++){
            for(int j=0;j<len-m+1;j++){
                boolean c=true;
                
                for(int x=0;x<m;x++){
                    for(int y=0;y<m;y++){
                        arr[i+x][j+y]+=key[x][y];
                    }
                }
                
                for(int x=m-1;x<m+n-1;x++){
                    for(int y=m-1;y<m+n-1;y++){
                        if(arr[x][y]!=1) c= false;
                    }
                }
                if(c)return true;
                for(int x=0;x<m;x++){
                    for(int y=0;y<m;y++){
                        arr[i+x][j+y]-=key[x][y];
                    }
                }
                
            }
        }return false;
    }
    public static int[][] rotate(int key[][]){
        int len=key.length;
        int temp[][]=new int[len][len];
        
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                temp[i][j]=key[len-j-1][i];
            }
        }
        return temp;
    }
}