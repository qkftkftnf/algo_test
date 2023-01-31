import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {
    public static int answer;
    public static HashSet<String> se=new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        
        dfs(user_id,banned_id,new boolean[user_id.length],0);
        
        return answer;
    }
    
    public static void dfs(String user_id[],String banned_id[],boolean visited[],int num){
        if(num==banned_id.length){
            if(find(visited)) answer++; 
            return;
        }
        String str=banned_id[num].replace('*','.');
        
        for(int i=0;i<user_id.length;i++){
            if(visited[i])continue;
            boolean check=Pattern.matches(str,user_id[i]);
            if(check){
                visited[i]=true;
                dfs(user_id,banned_id,visited,num+1);
                visited[i]=false;
            }
        }
    }
    public static boolean find(boolean visited[]){
        String s="";
        for(int i=0;i<visited.length;i++){
            if(visited[i]) s+=Integer.toString(i);
        }
        if(se.contains(s)) return false;
        else se.add(s);
        
        return true;
    }
}