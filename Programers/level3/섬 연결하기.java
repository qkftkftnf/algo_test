import java.util.Arrays;

class Solution {
    public static int arr[];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        arr=new int[n];
        Arrays.sort(costs,(o1,o2)->{
           return o1[2]-o2[2]; 
        });
        
        
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        
        for(int i=0;i<costs.length;i++){
            
            if(find(costs[i][0])==find(costs[i][1]))continue;
            else{
                answer+=costs[i][2];
                union(costs[i][0],costs[i][1]);
            }
        }
        
        return answer;
    }
    
    public static int find(int a){
        if(arr[a]==a) return a;
        else return find(arr[a]);
    }
    
    public static void union(int x, int y){
        int findX=find(x);
        int findY=find(y);
        
        if(findX!=findY) arr[findX]=findY;
    }
    
    
}