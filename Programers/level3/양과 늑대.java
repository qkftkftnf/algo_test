import java.util.Arrays;
class Solution {

    public static int answer=0;
    public int solution(int[] info, int[][] edges) {
        
        boolean visited[]=new boolean[info.length];
        visited[0]=true;
        dfs(edges,info,0,visited,0,0);
        return answer;
    }
    
    public static void dfs(int edges[][],int info[],int idx,boolean visited[],int sheep,int wolf){
        
        if(info[idx]==0){

            sheep++;
            answer=Math.max(sheep,answer);
        }else{
            wolf++;
        }
        
        
        if(wolf>=sheep) return;
        
        for(int i=0;i<edges.length;i++){
            if(visited[edges[i][0]] && !visited[edges[i][1]]){
                visited[edges[i][1]]=true;
                dfs(edges,info,edges[i][1],visited,sheep,wolf);
                visited[edges[i][1]]=false;
            }
        }
        
        
    }
    
}