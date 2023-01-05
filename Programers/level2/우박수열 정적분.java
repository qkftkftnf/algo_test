import java.util.LinkedList;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        LinkedList<Double> list=new LinkedList<>();
        
        double num=0;
        while(k>1){
            num=k;
            if(k%2==0){
                k/=2;
                num=(k+(double)(Math.abs(k-num)/2));
            }else{
                k=(k*3)+1;
                num=(num+(double)(Math.abs(k-num)/2));
            }
            list.add(num);
        }
        
        
        for(int i=0;i<ranges.length;i++){
            if(list.size()+ranges[i][1]<ranges[i][0])answer[i]=-1;
            else if(list.size()+ranges[i][1]==ranges[i][0])answer[i]=0;
            else{
                for(int j=ranges[i][0];j<list.size()+ranges[i][1];j++){
                    answer[i]+=list.get(j);
                }
            }
        }
        
        return answer;
    }
}