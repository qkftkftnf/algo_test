import java.util.*;

public class Main {
	public static class pos implements Comparable<pos>{
		int Smonth,Sday,Emonth,Eday;

		public pos(int smonth, int sday, int emonth, int eday) {
			super();
			Smonth = smonth;
			Sday = sday;
			Emonth = emonth;
			Eday = eday;
		}

		@Override
		public int compareTo(pos o) {
			if(this.Smonth == o.Smonth) {
				if(this.Sday== o.Sday) {
					if(this.Emonth==o.Emonth) {
						return o.Eday-this.Eday;
					}
					return o.Emonth-this.Emonth;
				}
				return this.Sday-o.Sday;
			}
			return this.Smonth-o.Smonth;
		}
		
		

		
	}
	public static int N;
	public static ArrayList<pos> list;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		list =new ArrayList<Main.pos>();
		
		int sm=0;
		int sd=0;
		int em=0;
		int ed=0;
		int count=0;
		
		
		for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int d=sc.nextInt();
			
			list.add(new pos(a,b,c,d));
		}
		
		Collections.sort(list);
		
		
		for(int i=0;i<N;i++) {
			if(em>11) break;
			if(i==0 && (list.get(i).Smonth>3 ||(list.get(i).Smonth==3 && list.get(i).Sday>1)))break;
			if((list.get(i).Smonth<3 || (list.get(i).Smonth==3 && list.get(i).Sday==1)) || i==0) {
				if(em<list.get(i).Emonth || (em==list.get(i).Emonth && ed<list.get(i).Eday)) {
					sm=list.get(i).Smonth;
					sd=list.get(i).Sday;
					em=list.get(i).Emonth;
					ed=list.get(i).Eday;
					count=1;
				}
			}
			else if(list.get(i).Smonth<sm || (list.get(i).Smonth==sm && list.get(i).Sday<=sd)) {
				if(list.get(i).Emonth>em || (list.get(i).Emonth== em&& list.get(i).Eday>ed)) {
					em=list.get(i).Emonth;
					ed=list.get(i).Eday;
				}
			}
			else if(list.get(i).Smonth<em ||(list.get(i).Smonth==em && list.get(i).Sday<=ed)) {
				if(list.get(i).Emonth<em || (list.get(i).Emonth == em && list.get(i).Eday<ed)) continue;
				sm=em;
				sd=ed;
				em=list.get(i).Emonth;
				ed=list.get(i).Eday;
				count++;
			}
			
		}
		if(em<12) count=0;
		System.out.println(count);

	}
}
