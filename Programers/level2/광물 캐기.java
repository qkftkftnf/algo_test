class Solution {
    public static int answer=Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        
        int num=0;
        for(int i=0;i<3;i++){
            num+=picks[i];
        }
        check(picks,minerals,0,0,num);
        return answer;
    }
    
    public void check(int picks[],String minerals[],int start,int point,int count){
        if(start>=minerals.length|| count==0){
            answer=Math.min(point,answer);
            return;
        }
        if(point>answer)return;
        for(int i=0;i<3;i++){
            if(picks[i]==0)continue;
            picks[i]--;
            check(picks,minerals,start+5,point+go(minerals,start,i),count-1);
            picks[i]++;

        }
 
    }
    
    public static int go(String[] minerals,int start,int n){
        if(n==0){
            return dia(minerals,start);
        }else if(n==1){
            return iron(minerals,start);
        }else{
            return stone(minerals,start);
        }
    }
    
    
    
    public static int dia(String[] minerals,int start){
        int num=0;
        for(int i=start;i<start+5;i++){
            if(i>=minerals.length)break;
                num+=1;
        }
        return num;
    }
    
    public static int iron(String[] minerals,int start){
        int num=0;
        for(int i=start;i<start+5;i++){
            if(i>=minerals.length)break;
            
            if(minerals[i].equals("diamond"))num+=5;
            else num+=1;
        }
        return num;
    }
    
    public static int stone(String[] minerals,int start){
        int num=0;
        for(int i=start;i<start+5;i++){
            if(i>=minerals.length)break;
            if(minerals[i].equals("diamond"))num+=25;
            else if(minerals[i].equals("iron")) num+=5;
            else num+=1;
        }
        return num;
    }
}