import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static LinkedList<Integer> plist=new LinkedList<>();
	public static LinkedList<Integer> mlist=new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int result=0;
		
		for(int i=0;i<N;i++) {
			int num=sc.nextInt();
			if(num>0)plist.offer(num);
			else mlist.offer(num);
		}
		Collections.sort(plist,Collections.reverseOrder());
		Collections.sort(mlist);
		
		int pnum=0;
		int nnum=0;
		int i=0;
		while(pnum == nnum) {
			if(i==plist.size() || i==mlist.size()) {
				pnum=plist.size();
				nnum=mlist.size();
				break;
			}
			pnum=plist.get(i);
			nnum=mlist.get(i)*-1;
			i++;
			
		}
		
		i=0;
		if(pnum>nnum) {
			while(plist.size()!=0) {
				if(i!=0)result+=plist.get(0)*2;
				else result+=plist.get(0);
				for(int n=0;n<M;n++) {
					if(plist.size()==0)break;
					plist.remove(0);
				}
				i++;
			}
			while(mlist.size()!=0) {
				result+=mlist.get(0)*-2;
				for(int n=0;n<M;n++) {
					if(mlist.size()==0)break;
					mlist.remove(0);
				}
			}
		}else {
			while(mlist.size()!=0) {
				if(i!=0)result+=mlist.get(0)*-2;
				else result+=mlist.get(0)*-1;
				for(int n=0;n<M;n++) {
					if(mlist.size()==0)break;
					mlist.remove(0);
				}
				i++;
			}
			while(plist.size()!=0) {
				result+=plist.get(0)*2;
				for(int n=0;n<M;n++) {
					if(plist.size()==0)break;
					plist.remove(0);
				}
			}
		}
		System.out.println(result);
	}

}
