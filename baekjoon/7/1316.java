package JOON;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int count=0;

		for(int i=0;i<a;i++) {
			int arr[]=new int[26];
			String word = scan.next();
			for(int j=0;j<word.length();j++) {		
			arr[word.charAt(j)-'a']++;
				if(j>0 && (arr[word.charAt(j)-'a']>1) && (word.charAt(j) != word.charAt(j-1))) {
					break;
				}else if(j==word.length()-1)
					count++;
			}		
		}
		System.out.println(count);
	}
}
