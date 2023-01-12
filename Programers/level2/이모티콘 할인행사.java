import java.util. Arrays;

class Solution {
    public static int people;
    public static int price;
    public int[] solution(int[][] users, int[] emoticons) {
        people=-1;
        price=0;
        int arr[]=new int[emoticons.length];
        Arrays.fill(arr,10);
        int[] answer = new int[2];


        dfs(users,emoticons,arr,0);

        answer[0]=people;
        answer[1]=price;

        return answer;
    }

    public static void dfs(int[][] users, int[] emoticons,int[] arr,int pos){

        if(pos==arr.length){
            int p=0;
            int m=0;

            for(int i=0;i<users.length;i++){
                int num=0;
                for(int j=0;j<arr.length;j++){
                    if(users[i][0]>arr[j]) continue;
                    num+=(emoticons[j]*0.01*(100-arr[j]));
                } 
                if(num>=users[i][1]) p++;
                else m+=num;
            }

            if(people<p){
                people=p;
                price=m;
            }else if(p==people){
                price=Math.max(price,m);
            }
            return;
        }
        for(int i=10;i<=40;i+=10){
            arr[pos]=i;
            System.out.println(Arrays.toString(arr));
            dfs(users,emoticons,arr,pos+1);  
        }



    }
}