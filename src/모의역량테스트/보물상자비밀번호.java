package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 보물상자비밀번호 {
	static int N,K;
	static char number[][];
	static List<String> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			number = new char[4][N/4];
			String input = br.readLine();
			char []inputnumber=input.toCharArray();
			int index=0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<N/4; j++) {
					number[i][j]=inputnumber[index++];
				}
			}
			
			solve();
			Collections.sort(list, Collections.reverseOrder());
			result(list.get(K-1));
			sb.append("#"+tc+" "+result(list.get(K-1))+"\n");
		}
		System.out.println(sb);
	}
	private static int result(String num) {
		int size=num.length();
		char []calnum=num.toCharArray();
		int numbers=0;
		int sum=0;
		int j=0;
		for(int i=size-1; i>=0; i--) {
			if(calnum[i]>=48 && calnum[i]<=57) { //숫자라면
				numbers=calnum[i]-'0';
			}
			else {
				numbers=(calnum[i]-'0')-7;
			}
			sum+=Math.pow(16,j++)*numbers;
		}
		return sum;
	}
	private static void solve() {
		for(int i=0; i<(N/4); i++) {
			store();
			rotate();
		}
		
	}
	private static void rotate() {
		int index=(N/4)-1;
		char tmp=number[3][index];
		for(int i=3; i>0; i--) {
			pushing(i,index);
			number[i][0]=number[i-1][index];
		}
		pushing(0,index);
		number[0][0]=tmp;
	}
	private static void pushing(int i,int index) {
		for(int j=index; j>0; j--) {
			number[i][j]=number[i][j-1];
		}
	}
	private static void store() {
		for(int i=0; i<4; i++) {
			String tmp="";
			for(int j=0; j<N/4; j++) {
				 tmp+=number[i][j];
			}
			if(!list.equals(tmp)) list.add(tmp);
		}
	}
}
