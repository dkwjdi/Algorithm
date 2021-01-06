package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 요리사 {
	static int min, foodInfo[][], N;
	static boolean check[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			N=Integer.parseInt(br.readLine());
			
			foodInfo=new int[N][N];
			check=new boolean[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					foodInfo[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			min=Integer.MAX_VALUE;
			combination(0,0,N/2);
			System.out.println("#"+tc+" "+min);
		}

	}


	private static void combination(int cnt, int start, int end) {
		if(cnt==end) {
			int synergy=0;
			List<Integer> foodA=new ArrayList<>();
			List<Integer> foodB=new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(check[i]) foodA.add(i);
				else foodB.add(i);
			}
			
			min=Math.min(min, Math.abs(cal(foodA)-cal(foodB)));
			return;
		}
		
		for(int i=start; i<N; i++) {
			check[i]=true;
			combination(cnt+1, i+1, end);
			check[i]=false;
		}
		
	}

	private static int cal(List<Integer> food) {
		int sum=0;
		int size=food.size();
		
		for (int i = 0; i < size-1; i++) {
			for(int j=i+1; j<size; j++) {
				sum+=foodInfo[food.get(i)][food.get(j)];
				sum+=foodInfo[food.get(j)][food.get(i)];
			}
		}
		return sum;
	}
}

