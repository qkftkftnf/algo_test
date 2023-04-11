import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public static int num[]=new int[2500];
    
    public String[] solution(String[] commands) {
        LinkedList<String> list=new LinkedList<>();
        String arr[]=new String[2500];
        String line[];
        
        for(int i=0;i<2500;i++){
            num[i]=i;
            arr[i]="";
        }
        
        for(int i=0;i<commands.length;i++){
            line=commands[i].split(" ");
            if(line[0].equals("UPDATE")){
                if(line.length>3){
                    arr[find(cnum(line[1],line[2]))]=line[3];
                }else{
                   for(int j=0;j<2500;j++){
                       if(line[1].equals(arr[j])){
                           arr[j]=line[2];
                       }
                   }
                }
            }else if(line[0].equals("MERGE")){
                int a=find(cnum(line[1],line[2]));
                int b=find(cnum(line[3],line[4]));
                String str=arr[a].isBlank()? arr[b]:arr[a];
                arr[a]="";
                arr[b]="";
                union(a,b);
                arr[a]=str;
            }else if(line[0].equals("UNMERGE")){
                int NUM=cnum(line[1],line[2]);
                int root=find(NUM);
                String str=arr[root];
                arr[root]="";
                arr[NUM]=str;
                LinkedList<Integer> dl=new LinkedList<>();
                
                for(int j=0;j<2500;j++){
                    if(root==find(j)){
                        if(NUM!=j)arr[j]=""; 
                        dl.add(j);
                    }
                }
                for(int j:dl){
                    num[j]=j;
                }
            }else{
                int NUM=cnum(line[1],line[2]);
                int root=find(NUM);
                
                if(arr[root].isBlank()) list.add("EMPTY");
                else list.add(arr[root]);
            }
        }
        
        
        String answer[]=new String[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
    
    public static int cnum(String a,String b){
        int num=(Integer.parseInt(a)-1)*50+Integer.parseInt(b);
        return num-1;
    }
    
    public static void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        
        if(pa!=pb){
            num[pb]=pa;
        }
    }
    
    public static int find(int a){
        if(num[a]==a) return a;
        else return num[a]=find(num[a]);
        
    }
}