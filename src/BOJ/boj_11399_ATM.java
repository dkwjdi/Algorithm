package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//7Ка
public class boj_11399_ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N=Integer.parseInt(br.readLine());
		int [] p=new int[N];
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			p[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(p);
		
		int result=p[0];
		
		for(int i=1; i<N; i++) {
			p[i]=p[i-1]+p[i];
			result+=p[i];
		}
		
		System.out.println(result);
		
	}

}
