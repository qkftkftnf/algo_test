import java.util.ArrayList;

class Solution {
    public static class pos{
        long x,y;
        
        public pos(long x,long y){
            super();
            this.x=x;
            this.y=y;
        }
    }
    public String[] solution(int[][] line) {
        int m=line.length;
        
        ArrayList<pos> list=new ArrayList<>();
        
        long maxx=0;
        long minx=0;
        long maxy=0;
        long miny=0;
        
        boolean first=true;
        long x=0;
        long y=0;
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                if(line[i][0] * line[j][1] - line[i][1] * line[j][0] == 0 )continue;
                long mom=line[i][0] * line[j][1] - line[i][1] * line[j][0];
                x=(line[i][1] * line[j][2] - line[i][2] * line[j][1]);
                y=(line[i][2] * line[j][0] - line[i][0] * line[j][2]);
                if(x%mom !=0 || y%mom !=0) continue;
                x/=mom;
                y/=mom;
                if(first){
                    maxx=minx=x;
                    maxy=miny=y;
                    first=false;
                }else{
                    maxx=Math.max(maxx,x);
                    minx=Math.min(minx,x);
                    maxy=Math.max(maxy,y);
                    miny=Math.min(miny,y);
                }
                list.add(new pos(x,y)); 
            }
        }
        
        int a=(int)(maxx-minx);
        int b=(int)(maxy-miny);
        
        if(a==0 && b==0){
            String answer1[]={"*"};
            return answer1;
        }
        
        String arr[][]=new String[b+1][a+1];
        String[] answer = new String[b+1];
        
        for(int i=0;i<=b;i++){
            for(int j=0;j<=a;j++){
                arr[i][j]=".";
            }
        }
        int calx=0;
        int caly=0;
        for(int i=0;i<list.size();i++){
            if(a!=0)calx=(int)(list.get(i).x-minx);
            if(b!=0)caly=(int)Math.abs(maxy-list.get(i).y);
            
            arr[caly][calx]="*";
        }
        
        for(int i=0;i<=b;i++){
            for(int j=0;j<=a;j++){
                if(answer[i]==null)answer[i]=arr[i][j];
                else answer[i]+=arr[i][j];
            }
        }
        return answer;
    }
}