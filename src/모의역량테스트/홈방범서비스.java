package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 홈방범서비스 {
	static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, result;
	static List<Point> homeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int homecheck=0;
			result=1;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			homeList=new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					homecheck=Integer.parseInt(st.nextToken());
					if(homecheck==1) homeList.add(new Point(i,j));
				}
			}
			solve();
			sb.append("#" + tc + " " + result + "\n");
		}

		System.out.println(sb);
	}

	private static void solve() {
		int homecount=0;
		for(int k=2; k<=N+1; k++) {  //k를 n+1크기까지 
			int cost= (k * k) + ((k - 1) * (k - 1)); //미리 cost구해놓고
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) { //배열 없지만 배열 돈다고 생각하고
					homecount=Math.max(homecount, innerHomeCheck(i,j,k,cost)); 
				}
			}
			result=Math.max(result, homecount); // k 크기 늘렸으니까 result랑 비교 
			
		}
		
	}

	private static int innerHomeCheck(int x, int y, int k,int cost) { //지금 위치에서 몇집 얻을 수 있냐 
		int cnt=0;
		for(int i=0; i<homeList.size(); i++) {
			Point point=homeList.get(i); //집 하나 뽑고 
			if(dircheck(x,y,point.x,point.y,k)) cnt++;  //만약 거리안에 있따면 cnt증가시켜줘 
		}
		
		if(cost<=cnt*M) return cnt; //만약 손해가 안난다면 
		return 0; //손해가 난다면 0 리턴
	}

	private static boolean dircheck(int x, int y, int x2, int y2, int k) {
		if(Math.abs(x-x2)+Math.abs(y-y2)<k) return true;  //거리에 있음 
		return false; //거리에 없음
	}
}
