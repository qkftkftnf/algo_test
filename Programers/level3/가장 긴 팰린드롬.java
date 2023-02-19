class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        String str[]=s.split("");
        
        for(int i=0;i<s.length()-1;i++){
            int count=1;
            int num=i-count;
            if(i<s.length()-2 && str[i].equals(str[i+2])){
                while(num>=0 && i+2+count<s.length()){
                    if(str[num].equals(str[i+2+count])){
                        count++;
                    }else{
                        break;
                    }
                    num=i-count;
                }
                answer=Math.max(count*2+1,answer);
            }
            count=1;
            num=i-count;
            if(str[i].equals(str[i+1])){
                while(num>=0 && i+1+count<s.length()){
                    if(str[num].equals(str[i+1+count])){
                        count++;
                    }else{
                        break;
                    }
                    num=i-count;
                }
                answer=Math.max(count*2,answer);
            }
        }


        return answer;
    }
}