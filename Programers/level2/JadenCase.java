class Solution {
    public String solution(String s) {
        String answer = "";
        String line[]=s.split("");
        char input;
        for(int i=0;i<line.length;i++){
          if(i==0 || (i>0 && line[i-1].equals(" "))){
              answer+=line[i].toUpperCase();
          }else{
              answer+=line[i].toLowerCase();
          }
        }
        
        return answer;
    }
}