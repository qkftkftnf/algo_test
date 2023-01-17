import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        int[] answer = new int[2];
        
        for(int i=0;i<operations.length;i++){
            String line[]=operations[i].split(" ");
            if(line[0].equals("I")){
                pq.offer(Integer.parseInt(line[1]));
            }else{
                if(!pq.isEmpty()){
                    if(line[1].equals("-1")){
                        pq.poll();
                    }else{
                        if(pq.size()==1) pq.poll();
                        else{
                            while(pq.size()>1){
                                pq1.offer(pq.poll());
                            }
                            pq.poll();
                            while(!pq1.isEmpty()){
                                pq.offer(pq1.poll());
                            }
                        }
                    } 
                }
               
            }
        }
        if(!pq.isEmpty()){
            answer[1]=pq.peek();
            
            while(!pq.isEmpty()){
                answer[0]=pq.poll();        
            }
        }
        return answer;
    }
}