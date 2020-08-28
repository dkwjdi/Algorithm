package BOJ길라잡이베타;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2751_수정렬하기2 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int N=sc.nextInt();
		int []array=new int[N];
		for(int i=0; i<N; i++) {
			array[i]=sc.nextInt();
		}
		Arrays.sort(array);
		
		for(int i=0; i<N; i++) {
			sb.append(array[i]+"\n");
		}
		System.out.println(sb);
	}

}
