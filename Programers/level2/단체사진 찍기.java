import java.util.HashMap;

class Solution {
    public static int answer;
    public static HashMap<String,Integer> map;
    public int solution(int n, String[] data) {
        answer = 0;
        map=new HashMap<>();
        map.put("A",0);
        map.put("C",1);
        map.put("F",2);
        map.put("J",3);
        map.put("M",4);
        map.put("N",5);
        map.put("R",6);
        map.put("T",7);
        
        dfs(data,new boolean[8],0,new int[8]);
        
        return answer;
    }
    
    public static void dfs(String data[],boolean visited[],int count,int arr[]){
        if(count==8){
            if(check(data,arr)) answer++;
            return;
        }
        
        for(int i=0;i<8;i++){
            if(visited[i])continue;
            visited[i]=true;
            arr[count]=i;
            dfs(data,visited,count+1,arr);
            visited[i]=false;
        }
        
    }
    
    public static boolean check(String data[],int arr[]){
        for(String s : data){
            String line[]=s.split("");
            int a=arr[map.get(line[0])];
            int b=arr[map.get(line[2])];
            
            
            if(line[3].equals("=")){
                if(Math.abs(a-b)!=(Integer.parseInt(line[4])+1))return false;
            }else if(line[3].equals("<")){
                if(Math.abs(a-b)>=(Integer.parseInt(line[4])+1))return false;
            }else{
                if(Math.abs(a-b)<=(Integer.parseInt(line[4])+1))return false;
            }
        }
        return true;
    }
    
    
    
}