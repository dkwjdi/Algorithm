package 시뮬레이션_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		long result=0; //최소 몇명?
		
		int N=Integer.parseInt(br.readLine());
		int people[]=new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) { //A 입력
			people[i]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			result++; //총시험관 한명추가
			people[i]-=B; //총시험관이 관리하는 수만큼 사람 수 빼줌
			if(people[i]<0) continue;
			result+=people[i]/C; //남은 사람 중 부시험관이 몇명 필요한지확인
			if(people[i]%C!=0) result++; // 딱 안나누어 떨어지면 1명추가
		}
		System.out.println(result);
	}

}
