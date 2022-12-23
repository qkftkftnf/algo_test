class Solution {
    public static int answer=0;
    public int solution(String s) {
        answer = s.length();
        
        String line[]=s.split("");
        
        
        for(int i=1;i<s.length();i++){
            check(i,line);
        }
        return answer;
    }
    
    public static void check(int len,String line[]){
        String result="";
        String word="";
        String temp="";
        int count=1;
        boolean c=true;
        for(int i=0;i<line.length;i++){
            if(i<len || temp.length()<len){
                temp+=line[i];
            }else if(word.length()<len){
                word+=line[i];
            }else{
                if(temp.equals(word)){
                    count++;
                }else{
                    if(count>1)result+=Integer.toString(count);
                    result+=temp;
                    temp=word;
                    count=1;
                    c=false;
                }
                
                word="";
                i--;
            }
        }
        if(!word.equals("")){
            if(temp.equals(word)){
                    count++;
            }
            if(count>1)result+=Integer.toString(count);
            result+=temp;
            if(!word.equals(temp))result+=word;
        }
        answer=Math.min(result.length(),answer);
    } 
}