class Solution {
    public static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        dfs(begin,target,words,new boolean[words.length],0);
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
    public static void dfs(String now,String target,String words[],boolean visited[],int count){
        if(now.equals(target)){
            answer=Math.min(answer,count);
            return;
        }else if(count>words.length){
            return;
        }else{
            for(int j=0;j<words.length;j++){
            int num=0;
            if(visited[j]) continue;
               for(int i=0;i<now.length();i++){
                    if(now.charAt(i)!=words[j].charAt(i)){
                        num++;
                    }
                    if(num>1) break;
                }
                if(num<2){
                    visited[j]=true;
                    dfs(words[j],target,words,visited,count+1);
                    visited[j]=false;
                }
            }
            
            
        }
    }
}