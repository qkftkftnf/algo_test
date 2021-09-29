//수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
//산술평균 : N개의 수들의 합을 N으로 나눈 값
//중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
//최빈값 : N개의 수들 중 가장 많이 나타나는 값
//범위 : N개의 수들 중 최댓값과 최솟값의 차이
//N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
import java.util.*;

public class Main {
	 
	 public static void main(String[] args) {	
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int arr[]=new int[a];
		
		for(int i=0;i<a;i++) {
			arr[i]=scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		Amean(arr,a);
		center(arr,a);
		many(arr,a);
		diff(arr,a);
		
		
	}	
	 public static void Amean(int[] arr,int count) {
		 double sum=0;
		 for(int i=0;i<count;i++) {
			 sum+=arr[i];
		 }
		 System.out.println(Math.round(sum/count));
	 }
	 
	 public static void center(int[] arr,int count) {
		 System.out.println(arr[count/2]);
	 }
	 
	 public static void many(int[] arr,int count) {
		 int a=0;
		 int repeat=0;
		 int mcount[]=new int[8002];
		 int sorted[]=new int[8002];
		 for(int i=0;i<count-1;i++) {
			 if(arr[i]==arr[i+1])
				 sorted[arr[i]+4000]++;
		 }
		 
		 for(int j=0;j<8002;j++) {
			 if(sorted[j]>repeat) {
				a=0;
				mcount[a++]=j;
			 	repeat=sorted[j];
			 }else if(sorted[j]==repeat ) {
				 mcount[a++]=j;
			 }
			 
			 
		 }
		 if(repeat==0 &&count!=1)
		 	System.out.println(arr[1]);
		 else if(count==1)
			 System.out.println(arr[0]);
		 else if(mcount[0]>mcount[1])
			 System.out.println(mcount[0]-4000);
		else
			System.out.println(mcount[1]-4000);
	 }
	 
	 public static void diff(int[] arr,int count) {
		 System.out.println(arr[count-1]-arr[0]);
	 }
	 
}
	 
	
