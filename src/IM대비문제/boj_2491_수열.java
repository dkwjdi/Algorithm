package IM대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2491_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int numbers[]=new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		int maxlen=0;
		int cnt=1;
		for(int i=0; i<N-1; i++) {
		
			if(numbers[i]<=numbers[i+1]) {
				cnt++;
			}
			else {
				maxlen=Math.max(cnt,maxlen);
				cnt=1;
			}
			if(i==N-2) maxlen=Math.max(cnt,maxlen);
		}
		
		cnt=1;
		for(int i=N-1; i>0; i--) {
			if(numbers[i]<=numbers[i-1]) {
				cnt++;
			}
			else {
				maxlen=Math.max(cnt,maxlen);
				cnt=1;
			}
			if(i==1) maxlen=Math.max(cnt,maxlen);
		}
		System.out.println(maxlen);
	}
}
