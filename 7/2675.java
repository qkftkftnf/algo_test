import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
	
		for(int i=0;i<a;i++) {
			int b = scan.nextInt();
			String c = scan.next();
			for(int k=0;k<c.length();k++) {
				for(int j=0;j<b;j++) {
				System.out.print(c.charAt(k));
				}
			}
			System.out.println("");
		}
	}	
}