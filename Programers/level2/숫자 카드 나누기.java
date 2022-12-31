import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int num=Math.max(arrayA[0],arrayB[0]);
        
        answer=Math.max(find(arrayA,arrayB,num), find(arrayB,arrayA,num));
        return answer;
    }
    
    public static int find(int arr1[],int arr2[],int num){
        int result=0;
        for(int i=num;i>0;i--){
            boolean check=true;
            for(int j=0;j<arr1.length;j++){
                if(arr1[j]%i!=0){
                    check=false;
                    break;
                }
            }
            if(check){
                for(int j=0;j<arr2.length;j++){
                    if(arr2[j]%i==0){
                        check=false;
                        break;
                    }
                }
                if(check){
                    result=i;
                    break;
                }
            }
        }
        return result;
        
    }
}