package BOJ길라잡이베타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int []A,B;
		int N=Integer.parseInt(br.readLine());
		A=new int[N];
		String input=br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		for(int i=0; i<N; i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		int M=Integer.parseInt(br.readLine());
		B=new int[M];
		input=br.readLine();
		st= new StringTokenizer(input);
		for(int i=0; i<M; i++) {
			B[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<M; i++) {
			sb.append(search(B[i],A)+"\n");
		}
		System.out.println(sb);
	}

	private static int search(int target, int []A) {
		int mid;
		int left=0;
		int right=A.length-1;
		
		while(right>=left) {
			mid=(left+right)/2;
			
			if(A[mid]==target) {
				return 1;
			}
			else if(A[mid]>target) { //더 왼쪽에 있다.
				right=mid-1;
			}
			else { //더 오른쪽
				left=mid+1;
			}
		}
		return 0;
	}

}
