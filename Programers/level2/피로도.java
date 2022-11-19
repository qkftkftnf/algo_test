import java.util.*;

class Solution {
    public static int answer=0;
    public int solution(int k, int[][] dungeons) {
        int n=dungeons.length;
        
        boolean visited[]=new boolean[n];
        
        dfs(k,n,dungeons,visited,0);
        
        return answer;
    }
    
    public static void dfs(int now,int len,int arr[][],boolean visit[],int count){
       
        
        for(int i=0;i<len;i++){
            if(now>=arr[i][0] && !visit[i]){
                visit[i]=true;
                dfs(now-arr[i][1],len,arr,visit,count+1);
                visit[i]=false;
            }
        }
        answer=Math.max(answer,count);
    }
}