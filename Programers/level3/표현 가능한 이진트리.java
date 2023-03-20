class Solution {
    public static int answer[];
    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            String l=Long.toBinaryString(numbers[i]);
            int j=0;
            
            while((int)Math.pow(2,j)-1<l.length()){
                j++;
            }
            int len=((int)Math.pow(2,j)-1)-l.length();
            for(int k=0;k<len;k++){
                l="0"+l;
            }
            if(dfs(l)) answer[i]=1;
            
        }
        return answer;
    }
    
    public static boolean dfs(String str){
        boolean check=true;
        
        
        int mid=str.length()/2;
        char root=str.charAt(mid);
        String left=str.substring(0,mid);
        String right=str.substring(mid+1,str.length());
        
        if(root=='0' &&(left.charAt(left.length()/2)=='1' || right.charAt(right.length()/2)=='1')){
            return false;
        }
            
            if(left.length()>=3){
                check=dfs(left);
                if(check){
                    check=dfs(right);
                }
            }
        
        return check;
        
    }
}