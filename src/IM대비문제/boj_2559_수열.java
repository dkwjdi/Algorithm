package IM대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int len=Integer.parseInt(st.nextToken());
		int arr[]=new int[n+1];
		st =new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int sum=0;
		int maxsum=Integer.MIN_VALUE;
		for(int i=1; i<=n-(len-1); i++) {
			for(int j=i; j<i+len; j++) {
				sum+=arr[j];
			}
			maxsum=Math.max(sum,maxsum);
			sum=0;
		}
		System.out.println(maxsum);
	}
}
