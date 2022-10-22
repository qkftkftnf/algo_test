//2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
import java.util.*;
import java.io.*;


public class Main {
	private static int[][] sorted=new int[200002][2];
	 
	 public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		
		int arr[][]=new int[a][2];
		
		for(int i=0;i<a;i++) {
			 String a1[] = br.readLine().split(" ");
	         arr[i][0] = Integer.parseInt(a1[0]);
	         arr[i][1] = Integer.parseInt(a1[1]);
		}
		
		mergesort(arr,0,a-1);
		
		for(int i=0; i<a; i++){
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
	}
	 private static void mergesort(int[][] a, int left,int right) {
			if(left==right)return; 

			int mid =(left + right)/2;

			mergesort(a,left,mid);
			mergesort(a,mid+1,right);

			merge(a,left,mid,right);

		 }

		 private static void merge(int[][] a, int left,int mid,int right) {
			 int l=left;
			 int r=mid+1;
			 int idx=left;

			 while(l<=mid && r<=right) {
				 if(a[l][0]<a[r][0]) {
					 sorted[idx]=a[l];
					 l++;
				 }
				 else if(a[l][0]==a[r][0]){
					 if(a[l][1]<a[r][1]) {
						 sorted[idx]=a[l];
						 l++;
					 }else {
						 sorted[idx]=a[r];
						 r++;
					 }
				 }
				 else {
					 sorted[idx]=a[r];
					 r++;
				 }
				 idx++;
			 }

			 if(l > mid) {
					while(r <= right) {
						sorted[idx] = a[r];
						idx++;
						r++;
					}
				}
				 else {
					 while(l<=mid) {
						 sorted[idx]=a[l];
						 idx++;
						 l++;
					 }
				 }

			 for(int i=left;i <=right;i++) {
				 a[i]=sorted[i];
			 }
		 }
}
	 
	
