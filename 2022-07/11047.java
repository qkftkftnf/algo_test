import java.util.Scanner;

public class Main {

	public static int N,K,arr[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		N=sc.nextInt();
		K=sc.nextInt();
		
		arr=new int [N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
			
		}
		greedy(0,0,N-1);
		
			
	}
	public static void greedy(int sum,int count,int pos) {
		if(sum==K){
			System.out.println(count);
			return;
		}else if(arr[pos]>K-sum) {
			greedy(sum,count,pos-1);
		}else {
			int num=(K-sum)/arr[pos];
			greedy(sum+(num*arr[pos]),count+num,pos-1);
		}
	}

}
