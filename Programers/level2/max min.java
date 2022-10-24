class Solution {
    public String solution(String s) {
        String answer = "";
        
        String line[]=s.split(" ");
        int num=line.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<num;i++){
            if(max<Integer.parseInt(line[i])) max=Integer.parseInt(line[i]);
            if(min>Integer.parseInt(line[i])) min=Integer.parseInt(line[i]);
        }
        answer=min+" "+max;
        return answer;
    }
}