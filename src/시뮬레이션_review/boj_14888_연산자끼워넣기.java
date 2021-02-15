package 시뮬레이션_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888_연산자끼워넣기 {
	static int N,nums[],ops[],max,min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		nums=new int[N];
		ops=new int[4];
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) { //   + - * %  순서대로    
			ops[i]=Integer.parseInt(st.nextToken());
		}
		
		solve(nums[0],1);
		System.out.println(max);
		System.out.println(min);
		
	}
	private static void solve(int result, int cnt) {
		if(cnt==N) {
			max=Math.max(max, result);
			min=Math.min(min, result);
			return;
		}
		//+
		if(ops[0]>0) {
			ops[0]--;
			solve(cal(result,nums[cnt],'+'),cnt+1);
			ops[0]++;
		}
		//-
		if(ops[1]>0) {
			ops[1]--;
			solve(cal(result,nums[cnt],'-'),cnt+1);
			ops[1]++;
		}
		//*
		if(ops[2]>0) {
			ops[2]--;
			solve(cal(result,nums[cnt],'*'),cnt+1);
			ops[2]++;
		}
		//%
		if(ops[3]>0) {
			ops[3]--;
			solve(cal(result,nums[cnt],'/'),cnt+1);
			ops[3]++;
		}
		
	}
	private static int cal(int num1, int num2, char op) {
		switch (op) {
		case '+': return num1+num2;
		case '*': return num1*num2;
		case '-': return num1-num2;
		case '/': return num1/num2;
		}
		return 0;
	}

}
