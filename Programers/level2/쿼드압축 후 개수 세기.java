class Solution {
    public static int answer[]=new int[2];
    public int[] solution(int[][] arr) {
        int len=arr.length;
        
        sq(0,0,len,arr);
        return answer;
    }
    
    public static void sq(int x,int y,int size, int arr[][]){
        if(check(x,y,size,arr)){
            answer[arr[x][y]]++;
            return;
        }
        sq(x,y,size/2,arr);
        sq(x+size/2,y,size/2,arr);
        sq(x,y+size/2,size/2,arr);
        sq(x+size/2,y+size/2,size/2,arr);
    }
    
    public static boolean check(int x,int y,int size,int arr[][]){
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[x][y]!=arr[i][j])return false;
            }
        }
        return true;
    }
}