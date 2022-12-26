import java.util.*;
class Solution {
    public static String arr[][];
    public static HashSet<String> set=new HashSet();
    public int solution(String[][] relation) {        
        arr=relation;
        int n=relation[0].length;
        cal(n,0,new boolean[n]);
        clean();
        return set.size();
    }
    
    
    public static void cal(int n,int num,boolean visited[]){
        String line="";
        for(int i=0;i<n;i++){
            if(visited[i])line+=i;
        }
        boolean check=true;
        HashSet <String> f=new HashSet();
        for(int i=0;i<arr.length;i++){
            String value="";
            for(int j=0;j<line.length();j++){
                value+=arr[i][line.charAt(j)-'0'];
            }
            if(!f.contains(value)){
                f.add(value);
            }else{
                check=false;
            }
        }          
        if(check)set.add(line);
        
        
        if(num>n)return;

        for(int i=num;i<n;i++){
            if(visited[i])continue;
            visited[i]=true;
            cal(n,i+1,visited);
            visited[i]=false;
        }
    }
    public static void clean(){
        LinkedList<String> list=new LinkedList<>();
        for(String s: set){
            for(String k:set){
                int count=0;
                if(s.equals(k))continue;
                for(int i=0;i<k.length();i++){
                    if(s.contains(k.charAt(i)+"")){
                        count++;
                    }
                }
                if(count==k.length()){
                    list.add(s);
                    break;
                }
            }
        }
        set.removeAll(list);
    }
}