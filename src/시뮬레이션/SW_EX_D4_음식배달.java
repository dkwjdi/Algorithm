package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_EX_D4_음식배달 {
	static class Home{
		int x,y;
		public Home(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Food{
		int x,y,cost; 
		public Food(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	static int N,result;
	static List<Home> homeList;
	static List<Food> foodList;
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			result = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			homeList = new ArrayList<>();
			foodList = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st= new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					int num=Integer.parseInt(st.nextToken());
					if(num==1) homeList.add(new Home(i,j));
					else if(num>1) foodList.add(new Food(i,j,num));
				}
			}
			visit=new boolean[foodList.size()];
			solve(0,foodList.size());
			System.out.println("#"+tc+" "+result);
		}
	}
	private static void solve(int cnt, int size) {
		if(cnt==size) {
			result = Math.min(result, dirCheck(size));
			return;
		}
		visit[cnt]=true;
		solve(cnt+1, size);
		visit[cnt]=false;
		solve(cnt+1, size);
	}
	private static int dirCheck(int size) {
		int sum=0;
		for(int i=0; i<homeList.size(); i++) { //집 한개 빼기
			Home home = homeList.get(i);
			int min=Integer.MAX_VALUE;
			for(int j=0; j<size; j++) {
				if(visit[j]) { //뽑혓으면 거리 계산 하러 ㄱ 
					Food food = foodList.get(j);
					min=Math.min(min, dir(home,food)); //거리계산해서 작은거 min에 넣어주기
				}
			}
			if(min==Integer.MAX_VALUE) continue;
			sum+=min;
		}
		if(sum==0) return Integer.MAX_VALUE;
	
		for(int i=0; i<size; i++) {
			if(visit[i]) sum+=foodList.get(i).cost;
		}
		return sum;
	}
	
	private static int dir(Home home, Food food) {
		return Math.abs(home.x-food.x)+Math.abs(home.y-food.y);
	}

}
