class Solution {
    public int solution(String name) {
        int answer = 0;
        int move=name.length()-1;

        int count=0;
        for(int i=0;i<name.length();i++){
            answer+=cal(name,i);
            count=i+1;
            while(count<name.length() && name.charAt(count)=='A'){
                count++;
            }
            
            move=Math.min(move,i*2+(name.length()-count)); // 오른쪽 갔다가 왼쪽으로
            move=Math.min(move,i+(name.length()-count)*2); // 왼쪽 갔다가 오른쪽으로
        }      
        return answer+move;
    }
    
    public static int cal(String name,int i){
        int max=26;
        int count=0;
        count=name.charAt(i)-'A';
        count=Math.min(max-count,count);
        return count;
    }
}