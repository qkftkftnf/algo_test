import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public static Queue<Integer> q=new LinkedList<>();
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        
        int num[]=new int[4];
        boolean check[]=new boolean[4];
        
        int first=0;
        int second=0;
        int arr[][]=new int[beginning.length][beginning[0].length];
        
        copy(arr,beginning,0);
        
        
        num[0]+=r(arr,target);
        num[0]+=c(arr,target);
        
         if(!check(arr,target)){
            check[0]=true;
            num[0]=Integer.MAX_VALUE;
        } 
        
        copy(arr,beginning,0);
        
        num[1]+=c(arr,target);
        num[1]+=r(arr,target);
        
        
         if(!check(arr,target)){
            check[1]=true;
            num[1]=Integer.MAX_VALUE;
        } 
        
        copy(arr,beginning,1);
        num[2]++;
        
        num[2]+=c(arr,target);
        num[2]+=r(arr,target);
        
        if(!check(arr,target)){
            check[2]=true;
            num[2]=Integer.MAX_VALUE;
        } 
        
        copy(arr,beginning,2);
        num[3]++;
        
        num[3]+=r(arr,target);
        num[3]+=c(arr,target);
        
        if(!check(arr,target)) {
            check[3]=true;
            num[3]=Integer.MAX_VALUE;
        }
        answer=Math.min(num[0],Math.min(num[1],Math.min(num[2],num[3])));
        if(check[0] && check[1] && check[2] && check[3]) return -1;
        else return answer;
    }
    
    
    public static int r(int arr[][],int target[][]){
        int res=0;
        for(int i=0;i<arr[0].length;i++){
            if(arr[0][i]!=target[0][i])q.offer(i);
        }
        res+=q.size();
        while(!q.isEmpty()){
            int num=q.poll();
            
            for(int i=0;i<arr.length;i++){
                arr[i][num]=(arr[i][num]+1)%2;
            }
        }
        
        return res;
    }
    
    public static int c(int arr[][],int target[][]){
        int res=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]!=target[i][0])q.offer(i);
        }
        res+=q.size();
        while(!q.isEmpty()){
            int num=q.poll();
            
            for(int i=0;i<arr[0].length;i++){
                arr[num][i]=(arr[num][i]+1)%2;
            }
        }
        return res;
    }
    
    public static boolean check(int arr[][], int target[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=target[i][j])return false;
            }
        }
        return true;
    }
    
    public static void copy(int arr[][],int beginning[][],int num){
        for(int i=0;i<beginning.length;i++){
            for(int j=0;j<beginning[i].length;j++){
                if((num==1 && i==0)|| (num==2 && j==0)) arr[i][j]=(beginning[i][j]+1)%2;
                else arr[i][j]=beginning[i][j];
            }
        }
    }
    
    
    
}