import java.util.Arrays;
class Solution {
    public static int ww[][],answer;
    public int solution(int n, int[] weak, int[] dist) {
        answer = dist.length+1;
        
        ww=new int[weak.length][weak.length];
        int arr[]=new int[dist.length];
        boolean visited[]=new boolean[dist.length];
        
        int num=0;
        for(int i=0;i<weak.length;i++){
            for(int j=0;j<weak.length;j++){
                num=i+j;
                if(num>=weak.length){
                    num%=weak.length;
                     ww[i][j]=n+weak[num];
                }
                else ww[i][j]=weak[i+j];
            }
        }
        
        
        dfs(n,weak,dist,arr,visited,0);
        if(answer>dist.length) return -1;
        return answer;
    }
    
    public static void dfs(int n, int weak[],int dist[],int arr[],boolean visited[],int count){
        if(count==dist.length){
            int j=0;
            for(int i=0;i<weak.length;i++){
                int pos=0;
                int num=ww[i][pos];
                boolean check=false;
                for(j=0;j<arr.length;j++){
                    num+=arr[j];
                    while(num>=ww[i][pos]){
                        pos++;
                        if(pos>=weak.length){
                            check=true;
                            break;
                        }
                    }
                    if(check){
                        answer=Math.min(j+1,answer);
                        break;
                    }else{
                        num=ww[i][pos];
                    }
                }
                
            }
            
            
            return;
        }
        
        for(int i=0;i<dist.length;i++){
            if(visited[i])continue;
            visited[i]=true;
            arr[count]=dist[i];
            dfs(n,weak,dist,arr,visited,count+1);
            visited[i]=false;
        }
        
        
        
        
        
        
    }
}