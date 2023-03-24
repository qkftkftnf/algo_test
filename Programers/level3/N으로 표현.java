import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        ArrayList<Set<Integer>> list=new ArrayList<>();
        
        for(int i=0;i<9;i++){
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        
        for(int i=2;i<9;i++){
            Set<Integer> count=list.get(i);
            for(int j=1;j<i;j++){
                Set<Integer> pre=list.get(j);
                Set<Integer> post=list.get(i-j);
                
                for(int num1:pre){
                    for(int num2:post){
                        count.add(num1+num2);
                        count.add(num1-num2);
                        count.add(num1*num2);
                        
                        if(num1!=0 && num2!=0){
                            count.add(num1/num2);
                        }
                    }
                } 
            }
            count.add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }
        
 
        for(Set<Integer> s:list){
            if(s.contains(number)) return answer;
            answer++;
        }
        return -1;
    }
}