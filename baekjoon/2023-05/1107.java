import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int num=0;
		boolean arr[]=new boolean[10];
		
		for(int i=0;i<m;i++) {
			num=sc.nextInt();
			arr[num]=true;
		}
		

		int result=(int)Math.abs(n-100);
		
		for(int i=0;i<=999999;i++) {
			String str=Integer.toString(i);
			int len=str.length();
			
			boolean check=true;
			for(int j=0;j<len;j++) {
				if(arr[str.charAt(j)-'0']) {
					check=false;
					break;
				}
			}
			
			if(check) {
				result=Math.min((int)Math.abs(n-i)+len,result);
			}
		}
		System.out.print(result);
		
		

		
	}
	


}
