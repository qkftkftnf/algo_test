package JOON;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int count=1;
		int cro=1;
		int mo,ja;
		
		if(a==1) {
			System.out.println("1/1");
		}
		else {
			while(true) {
				count++;
				cro+=count;
				if(a<=cro) {
					mo=cro-a+1;
					ja=count+1-mo;
					break;
				}
			}
			if(count%2==0)
				System.out.println(ja+"/"+mo);
			else
				System.out.println(mo+"/"+ja);
		
		}
	}	
}
