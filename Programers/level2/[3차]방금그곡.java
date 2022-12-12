import java.util.*;

class Solution {
    public static class pos implements Comparable<pos>{
        String title;
        int time;
        int count;
        public pos(String title,int time,int count){
            super();
            this.title=title;
            this.time=time;
            this.count=count;
        }
        
        public int compareTo(pos o) {
            if(o.time==this.time){
                return this.count-o.count;
            }
			return o.time-this.time;
		}
    }
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<pos> pq=new PriorityQueue<>();
        int count=0;
        String answer = "(None)";
        
        for(int i=0;i<musicinfos.length;i++){
            String info[]=musicinfos[i].split(",");
            String start[]=info[0].split(":");
            String end[]=info[1].split(":");
            int time=(Integer.parseInt(end[0])*60+Integer.parseInt(end[1]))-(Integer.parseInt(start[0])*60+Integer.parseInt(start[1]));
            String str="";
            int j=0;
            int pos=0;
            while(true){
                if(j>=time){
                    if(info[3].charAt(pos%(info[3].length()))=='#') str+=(info[3].charAt(pos%(info[3].length()))+"");
                    break;
                }
                str+=(info[3].charAt(pos%(info[3].length()))+"");
                if(info[3].charAt(pos%(info[3].length()))!='#'){
                    j++;
                }
                pos++;
            }
            System.out.print(str);
            // for(int k=0;k<m.length();k++){
            //     String s=m.substring(k,m.length());
            //     s+=m.substring(0,k);
            //     if(s.charAt(0)!='#')
            // }
            String check=str.replaceAll(m,"K");
            String Dcheck=check.replaceAll("K#","");
            if(!(check.replaceAll("K","").equals(check)) && !(Dcheck.replaceAll("K","").equals(Dcheck))){
                pq.offer(new pos(info[2],time,count++));
            }
            
        }
        if(!pq.isEmpty())return pq.peek().title; 
        return answer;
    }
}