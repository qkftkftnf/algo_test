import java.util.PriorityQueue;

class Solution {
    public int[] solution(String s) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        String check[]=s.split("},");
        int num=check.length;
        
        s=s.replaceAll("\\{","").replaceAll("\\}","");
        String arr[]=s.split(",");
        
        int[] answer = new int[num];
        for(int i=0;i<arr.length;i++){
            pq.offer(Integer.parseInt(arr[i]));
        }
        
        int before=pq.poll();
        
        if(pq.isEmpty())answer[0]=before;
        
        int count=1;
        int last=0;
        while(!pq.isEmpty()){
            if(before!=pq.peek()){
                answer[num-count]=before;
                before=pq.peek();
                count=1;
            }else{
                count++;
            }
            last=pq.poll();
        }
        for(int i=0;i<num;i++){
            if(answer[i]==0){
                answer[i]=last;
                break;
            }
        }
        System.out.print(num);
        return answer;
    }
}