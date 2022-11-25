import java.util.*;

class Solution {
    public static class pos implements Comparable<pos>{
        String head;
        String number;
        String tail;
        
        public pos(String head, String number,String tail){
            super();
            this.head=head;
            this.number=number;
            this.tail=tail;
        }
        
         
        public int compareTo(pos e){
            String head1=this.head.toLowerCase();
            String head2=e.head.toLowerCase();
            
            if(head1.equals(head2)){
                int num1=Integer.parseInt(this.number);
                int num2=Integer.parseInt(e.number);
                return num1-num2;
            }
            return head1.compareTo(head2);
        }
    }
    public String[] solution(String[] files) {
        
        int len=files.length;
        String answer[]=new String[len];
        LinkedList<pos> list=new LinkedList<>();
        
        for(int i=0;i<len;i++){
            int x=0;
            String head="";
            while(true){
                if(files[i].charAt(x)>='0' && files[i].charAt(x)<='9'){
                    break;
                }
                head+=files[i].charAt(x);
                x++;
            }
            String number="";
            while(true){    
                if(x>=files[i].length() ||files[i].charAt(x)<'0' || files[i].charAt(x)>'9'){
                    break;
                }
                number+=files[i].charAt(x);
                x++;
            }
            String tail="";
            if(x<files[i].length()){
                tail=files[i].substring(x);
            }
            list.add(new pos(head,number,tail));
            
        }
        Collections.sort(list);
        for(int i=0;i<len;i++){
            answer[i]=list.get(i).head +list.get(i).number+list.get(i).tail;
        }
        
        return answer;
    }
}