import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        HashMap<Integer,Long> map=new HashMap<>();
        
        long answer = 0;
        long count=0;
        int num=0;
        Arrays.sort(weights);
        for(int i=0;i<weights.length;i++){
            if(!map.containsKey(weights[i])){
                map.put(weights[i],(long)1);
            }else{
                map.put(weights[i],map.get(weights[i])+(long)1);
            }
        }
        
        int a=0;
        int b=0;
        
        for(int i : map.keySet()){
            for(int k=2;k<=4;k++){
                num=i*k;
                a=cal(k+1);
                b=cal(k+2);
                
                if(num%a==0 &&map.containsKey(num/a)){
                    answer+=(map.get(i)*map.get(num/a));
                }
                
                if(num%b==0 &&map.containsKey(num/b)){
                    answer+=(map.get(i)*map.get(num/b));
                }  
            }
            for(long j=1;j<map.get(i);j++){
                count+=j;
            }
        }
        
        
        return answer/2+count;
    }
    
    public static int cal(int a){
        if(a>4)a=(a%4)+1;
        return a;
    }
}