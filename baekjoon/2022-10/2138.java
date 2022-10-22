import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int arr1[],arr2[],goal[],N;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			N=Integer.parseInt(br.readLine());

			arr1=new int [N+1];
			arr2=new int [N+1];
			goal=new int [N+1];
			
			String line[]=br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr1[j+1]=Integer.parseInt(line[j]);
			}
			line=br.readLine().split("");
			for(int i=0;i<N;i++) {
				goal[i+1]=Integer.parseInt(line[i]);
			}
			arr2=arr1.clone();
			change(1,2);
			int result1=0;
			int result2=1;
			
			for(int i=2;i<=N;i++) {
				if(arr1[i-1]!=goal[i-1]) {
					change(i,1);
					result1+=1;
				}
				if(arr2[i-1]!=goal[i-1]) {
					change(i,2);
					result2+=1;
				}
			}
			
			for(int i=1;i<=N;i++) {
				if(arr1[i]!=goal[i])result1=-1;
				if(arr2[i]!=goal[i])result2=-1;
			}
			
			if(result1 == result2 && result1==-1)System.out.println(result1);
			else {
				if(result1==-1) {
					System.out.println(result2);
				}else if(result2==-1) {
					System.out.println(result1);
				}else {
					System.out.println(Math.min(result1, result2));
				}
			}			
	}
	
	public static void change(int i,int k) {
		if(k==1) {
			if(i>1)arr1[i-1]=Math.abs(arr1[i-1]-1);
			arr1[i]=Math.abs(arr1[i]-1);
			if(i<N)arr1[i+1]=Math.abs(arr1[i+1]-1);
		}else {
			if(i>1)arr2[i-1]=Math.abs(arr2[i-1]-1);
			arr2[i]=Math.abs(arr2[i]-1);
			if(i<N)arr2[i+1]=Math.abs(arr2[i+1]-1);
		}
	}
	
	

}
