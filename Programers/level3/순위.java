class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int arr[][]=new int[n+1][n+1];
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i!=j)arr[i][j]=5000;
            }
        }
        
        for(int i=0;i<results.length;i++){
            arr[results[i][1]][results[i][0]]=1;
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    arr[i][j]=Math.min(arr[i][k]+arr[k][j],arr[i][j]);
                }
            }
        }
        for(int i=1;i<=n;i++){
            int count=0;
            for(int j=1;j<=n;j++){
                if(arr[i][j]!=5000 || arr[j][i]!=5000)count++;
            }
            if(count==n)answer++;
        }
        return answer;
    }
}