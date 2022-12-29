class Solution {
    
    public static int arr[];
    public static boolean visited[];
    public static int answer;
    public int solution(int n) {
        answer = 0;
        arr=new int[n];
        visited=new boolean[n];
        
        dfs(n,0); 
        
        return answer;
    }
    
    public static void dfs(int n, int i){
        if(n==i){
            answer++;
            return;
        }
        
        for(int j=0;j<n;j++){
            if(visited[j])continue;
            visited[j]=true;
            arr[i]=j;
            if(check(i))dfs(n,i+1);
            visited[j]=false;
        }
    }
    
    public static boolean check(int i){
        for(int j=0;j<i;j++){
            if(arr[j]==arr[i])return false;
            if(Math.abs(i-j) == Math.abs(arr[j]-arr[i]))return false;
        }
        return true;
    }
}