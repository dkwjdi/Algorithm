import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_16637_괄호추가하기 {
	static int N;
	static int max;
	static  List<Integer> num;
	static  List<Character> op;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N=Integer.parseInt(br.readLine());
		 String inputData = br.readLine();
		 
		 max=Integer.MIN_VALUE;
		 num=new ArrayList<>();
		 op=new ArrayList<>();
		 
		 for(int i=0; i<N; i++) {
			 char data = inputData.charAt(i);
			 if(Character.isDigit(data)) num.add(data-'0');
			 else op.add(data);
		 }
		 
		 solve(num.get(0), 0);
		 System.out.println(max);
		
	}
	private static void solve(int result, int opIdx) {
		if(opIdx>=op.size()) {
			max=Math.max(result, max);
			return;
		}
		
		solve(cal(result, num.get(opIdx+1), opIdx), opIdx+1);
		
		if(opIdx+1 < op.size()) {
			int next=cal(num.get(opIdx+1), num.get(opIdx+2), opIdx+1);
			
			solve(cal(result, next, opIdx), opIdx+2);
			
		}
		
		
		
	}
	private static int cal(int result, int num, int opIdx) {
		char getOp=op.get(opIdx);
		switch (getOp) {
		case '+':
			return result+num;
		case '-':
			return result-num;
		case '*':
			return result*num;
		case '/':
			return result/num;
		}
		return 0;
	}

}
