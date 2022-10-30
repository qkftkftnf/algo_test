class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        
        loop:
        for(int i=0;i<words.length;i++){
            
            for(int j=0;j<i;j++){
                
                if(words[i].equals(words[j])){
                    answer[0]=(i%n)+1;
                    answer[1]=(i/n)+1;
                    break loop;
                }
            }
            String line[]=words[i].split("");
            int len=words[i].length();
            if(i!=words.length-1 && !words[i+1].startsWith(line[len-1])){
                answer[0]=((i+1)%n)+1;
                answer[1]=((i+1)/n)+1;
                break;
            }
        }
        

        return answer;
    }
}