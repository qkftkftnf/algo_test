import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static int N,M,limit[],result,max;
	public static LinkedList<Integer>list=new LinkedList<>();
	public static LinkedList<Integer>box=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		result=0;
		max=Integer.MIN_VALUE;
		N=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
			if(list.get(i)>max)max=list.get(i);
		}
		M=sc.nextInt();
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			box.add(a);
			if(a>max)result=-1;
		}
		if(result==-1)System.out.println(result);
		else {
			Collections.sort(list,Collections.reverseOrder());
			Collections.sort(box,Collections.reverseOrder());
			
			while(!box.isEmpty()) {
				int num=0;
				result++;
				for(int i=0;i<N;i++) {
					if(box.isEmpty()||box.get(box.size()-1)>list.get(i))break;
					while(num<box.size()) {
						if(box.get(num) <=list.get(i)) {
							box.remove(num);
							break;
						}
						num++;
					}
				}
			}
			System.out.println(result);
		}

	}

}
