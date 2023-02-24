import java.util.HashMap;

class Solution {
    public static HashMap<String,Integer> map;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        map=new HashMap<>();
        int n=enroll.length;
        int[] answer = new int[n];
        
        for(int i=0;i<n;i++){
            map.put(enroll[i],i);
        }
        
        for(int i=0;i<seller.length;i++){
            int k=map.get(seller[i]);
            int money=amount[i]*100;
            
            while(true){
                int don=(int)(money*0.1);
                answer[k]+=(money-don);
                if(!map.containsKey(referral[k]) || don==0)break;
                else{
                    money=don;
                    k=map.get(referral[k]);
                }
            }
        }
        return answer;
    }
}