import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static int answer=0;
    public int solution(int n, int[][] wires) {
        answer=n;
        int arr[][]=new int [n+1][n+1];
        
        for(int i=0;i<wires.length;i++){
            arr[wires[i][0]][wires[i][1]]=1;
            arr[wires[i][1]][wires[i][0]]=1;
        }

         for(int i=0;i<wires.length;i++){
            arr[wires[i][0]][wires[i][1]]=0;
            arr[wires[i][1]][wires[i][0]]=0;
            check(n,arr,new boolean[n+1]);
            arr[wires[i][0]][wires[i][1]]=1;
            arr[wires[i][1]][wires[i][0]]=1;
        }
        return answer;
    }
    public static void check(int n,int arr[][],boolean visited[]){
        Queue<Integer> q= new LinkedList<>();
        q.offer(1);
        visited[1]=true;
        
        int count=1; 
        while(!q.isEmpty()){
            int now=q.poll();
            for(int i=1;i<=n;i++){
                if(arr[now][i]==1 && !visited[i]){
                   visited[i]=true;
                    q.offer(i);
                    count++;
                }
            }
        }
        int num=n-count;
        answer=Math.min(Math.abs(num-count),answer);
        
        
    }
}