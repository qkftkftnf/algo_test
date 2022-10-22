import java.util.Scanner;

public class Main {
	public static int N,arr[][],result=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		
		arr=new int[N+1][2];
		for(int i=1;i<=N;i++) {
			for(int j=0;j<2;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		cal(0,0,1);
		System.out.println(result);
	}
	
	public static void cal(int sum,int count,int today) {
		result=Math.max(result, sum);
		if(today==N+1)return;
		if(count==0 && today+arr[today][0]-1<=N) {
			cal(sum+arr[today][1],arr[today][0]-1,today+1);
			cal(sum,count,today+1);
		}else if(count>0){
			cal(sum,count-1,today+1);
		}else {
			cal(sum,count,today+1);
		}
		
	}

}
