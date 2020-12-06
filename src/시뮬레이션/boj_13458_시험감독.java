package 시뮬레이션;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13458_시험감독 {
	static int N, B, C, A[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		A=new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		st= new StringTokenizer(br.readLine());
		B=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		long result=0;
		for(int i=0; i<N; i++) {
			result++;
			int num=A[i]-B;
			if(num<=0) continue;
			
			result+=num/C;
			if(num%C!=0) result++;
		}
		
		System.out.println(result);
	}

}
