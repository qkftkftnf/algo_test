import java.util.Arrays;

class Solution {
    public static int answer[];
    public static int max=-1;
    public int[] solution(int n, int[] info) {
        answer=new int[11];
        
        dfs(n,info,new int[11],10,0,0);
        
        if(max==-1) {
            answer=new int[1];
            answer[0]=-1;
        }
        return answer;
    }
    
    public static void dfs(int n,int info[],int arr[],int point,int ape,int lion){
        if(point<0){
            if(n>0){
                arr[10]+=n;
                n=0;
            }
            
            if(n==0 && lion >ape){
                if(max<lion-ape){
                    max=lion-ape;
                    answer=arr.clone();
                }
                if(max==lion-ape){
                    for(int i=10;i>0;i--){
                        if(answer[i]>0 && arr[i]<answer[i]) break;
                        else if(arr[i]>0 && arr[i]>answer[i]){
                            answer=arr.clone();
                            break;
                        }
                    }
                }
            }
            return;
        }
        if(n<0) return;
        
        int num=info[10-point];
        
        
        
        arr[10-point]=num+1;
        n-=(num+1);
        if(n>=0) dfs(n,info,arr,point-1,ape,lion+point);
        
        arr[10-point]=0;
        n+=(num+1);
        if(num==0)dfs(n,info,arr,point-1,ape,lion);
        else dfs(n,info,arr,point-1,ape+point,lion);
        
    }
}