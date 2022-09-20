import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line[]=br.readLine().split(" ");
		
		int N=Integer.parseInt(line[0]);
		int K=Integer.parseInt(line[1]);
		
		String Snum[]=br.readLine().split(" ");
		int count[]=new int[K+1]; 
		int num[]=new int[K];
		int wid[][]=new int[K+1][K+1];
		boolean visited[]=new boolean[K+1];
		
		for(int i=K-1;i>=0;i--) {
			num[i]=Integer.parseInt(Snum[i]);
			count[num[i]]++;
			wid[num[i]][count[num[i]]]=i;
		}
		int s=0;
		
		for(int i=0;i<N;i++) {
			if(s>=K) {
				break;
			}
			if(!visited[num[s]]) {
				count[num[s]]--;
				visited[num[s]]=true;
			}else {
				count[num[s]]--;
				i--;
			}
			s++;
		}
		
		
		
		int result=0;
		if(s<K) {
			int pos=0;
			for(int i=s;i<K;i++) {
				if(!visited[num[i]]) {
					int min=Integer.MIN_VALUE;
					for(int j=1;j<=K;j++) {
						if(count[j]==0 && visited[j]) {
							pos=j;
							break;
						}
						else if(visited[j]&& wid[j][count[j]]>min ) {
							min=wid[j][count[j]];
							pos=j;
						}
					}
					visited[pos]=false;
					visited[num[i]]=true;
					result++;
				}
				count[num[i]]--;
				
			}
		}
		System.out.println(result);
		
	}

}