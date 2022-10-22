//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
import java.util.*;
import java.io.*;

public class Main {
	 private static int[] sorted=new int[1000000];
	 
	 public static void main(String[] args) throws IOException {	
		 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int a = Integer.parseInt(br.readLine());
			
			int arr[]=new int[a];
		
			
			for(int i=0;i<a;i++) {
				arr[i]=Integer.parseInt(br.readLine());
			}
			
			mergesort(arr,0,arr.length-1);
			
			for(int i=0;i<a;i++) {
				bw.write(Integer.toString(arr[i])+"\n");
			}
			bw.flush();
			bw.close();
	 }
	 
	 
	 private static void mergesort(int[] a, int left,int right) {
		if(left==right)return; 
		
		int mid =(left + right)/2;
		
		mergesort(a,left,mid);
		mergesort(a,mid+1,right);
		
		merge(a,left,mid,right);
		
	 }
	 
	 private static void merge(int[] a, int left,int mid,int right) {
		 int l=left;
		 int r=mid+1;
		 int idx=left;
		 
		 while(l<=mid && r<=right) {
			 if(a[l]<=a[r]) {
				 sorted[idx]=a[l];
				 l++;
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
	 
	
