class Solution {
    public static int arr[]=new int[1451];
    public int solution(String[][] book_time) {
        int answer = 0;
        for(int i=0;i<book_time.length;i++){
            int s=time(book_time[i][0]);
            int e=time(book_time[i][1])+10;
            arr[s]+=1;
            arr[e]-=1;
        }
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
            answer=Math.max(arr[i],answer);
        }
        
        
        return answer;
    }
    
    public static int time(String str){
        String s[]=str.split(":");
        int num=0;
        num+=60*Integer.parseInt(s[0]);
        num+=Integer.parseInt(s[1]);
        return num;
    }
}