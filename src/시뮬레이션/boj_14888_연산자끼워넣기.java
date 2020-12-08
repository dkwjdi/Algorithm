package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14888_연산자끼워넣기 {
	static int N,min,max,opArray[];
	static boolean visited[];
	static List<Integer> nums= new ArrayList<>();
	static List<Character> ops= new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		visited= new boolean[N-1];
		opArray= new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			input(i,Integer.parseInt(st.nextToken()));
		}
		
		min=Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		permutation(0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void permutation(int cnt) {
		if(cnt==N-1) {
			solve(nums.get(0),0);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(visited[i]) continue;
			opArray[cnt]=i;
			visited[i]=true;
			permutation(cnt+1);
			visited[i]=false;
		}
	}
	private static void solve(int result, int cnt) {
		if(cnt==N-1) {
			min=Math.min(result, min);
			max=Math.max(result, max);
			return;
		}
		
		solve(cal(result,nums.get(cnt+1), opArray[cnt]), cnt+1);
		
	}
	private static int cal(int num1, int num2, int cnt) {
		char op=ops.get(cnt);
		switch (op) {
		case '*': return num1*num2;
		case '+': return num1+num2;
		case '-': return num1-num2;
		case '/': return num1/num2;
		}
		return 0;
	}
	private static void input(int i, int op) {
		switch (i) {
		case 0:
			inputop(op,'+');
			break;
		case 1:
			inputop(op,'-');
			break;
		case 2:
			inputop(op,'*');
			break;
		case 3:
			inputop(op,'/');
			break;
		}
	}
	private static void inputop(int size, char c) {
		for(int i=0; i<size; i++) {
			ops.add(c);
		}
	}

}
