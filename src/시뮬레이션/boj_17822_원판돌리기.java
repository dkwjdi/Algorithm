package 시뮬레이션;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17822_원판돌리기 {
	static class Info {
		int x, d, k;
		public Info(int x, int d, int k) {
			this.x = x;
			this.d = d;
			this.k = k;
		}
	}
	static class Num{
		int num, remove;
		public Num(int num, int remove) {
			this.num = num;
			this.remove = remove;
		}
	}

	static int N, M, T;
	static List<Num> list[];
	static List<Info> info;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		info = new ArrayList<>();
		list = new List[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i].add(new Num(Integer.parseInt(st.nextToken()) ,0) );
			}
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			info.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		System.out.println(solve());
	}

	private static int solve() {

		for (int i = 0; i < T; i++) {
			Info tmp = info.remove(0);
			//원판 회전 
			rotate(tmp.d,tmp.x,tmp.k);
		
			if(isNum()) { //남은 숫자가 있다면 
				if(!removeNum()) { //숫자 못지웠다면
					avg(); //평균구해서 빼러 가자 
				}
				else { //숫자 지웠다면 remove 가 1 인 숫자를 -1로 다 바꿔줌 
					chagneNum();
				}
				
			}
			else return 0;
		}
		
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(list[i].get(j).num==-1) continue;
				sum+=list[i].get(j).num;
			}
		}

		
		return sum;

	}

	private static void chagneNum() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(list[i].get(j).num==-1) continue;
				if(list[i].get(j).remove==1) {
					Num num = list[i].get(j);
					num.num=-1;
				}
			}
		}
	}

	private static boolean removeNum() {
		boolean flag=false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				Num num = list[i].get(j);
				if(num.num==-1) continue ; // 만약 -1이라면 스킵
				
				
				for(int d=0; d<4; d++) {
					int nx=i+dx[d];
					int ny=j+dy[d];
					
					if(nx==-1 || nx==N) continue;
					if(ny==-1) ny=M-1;
					else if(ny==M) ny=0;
					
					if(nearNumCheck(i,j,nx,ny)) { //숫자가 같아서 remove 를 표시 했다면 
						flag=true;
					}
				}
			}
		}
		return flag;
	}

	private static boolean nearNumCheck(int x, int y, int nx, int ny) { // x y 랑 nx ny 비교 
		if(list[x].get(y).num==list[nx].get(ny).num) {
			list[x].get(y).remove=1;
			list[nx].get(ny).remove=1;
			return true;
		}
		return false;
	}

	private static boolean isNum() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(list[i].get(j).num!=-1) return true; //숫자 있다면 
			}
		}
		return false; //없다면 
	}

	private static void avg() {
		double sum=0;
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int tmp=list[i].get(j).num;
				if(tmp!=-1) {
					sum+=tmp;
					cnt++;
				}
			}
		}
		
		if(cnt==0) return ;
		sum/=cnt;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				Num tmp=list[i].get(j);
				if(tmp.num==-1) continue;
				if(tmp.num>sum) tmp.num--;
				else if(tmp.num<sum) tmp.num++;
			}
		}
	}


	private static void rotate(int d, int x, int k) { // d 0 -> 시계 1 ->반시계 k는 몇번돌릴꺼냐
		int tmpx=x;
		
		while (tmpx <= N) {
			if (d == 0) { // 시계
				for (int i = 0; i < k; i++) {
					Num tmp = list[tmpx-1].remove(M - 1);
					list[tmpx-1].add(0, tmp);
				}
			} else if (d == 1) { // 반시계
				for (int i = 0; i < k; i++) {
					Num tmp = list[tmpx-1].remove(0);
					list[tmpx-1].add(tmp);
				}
			}
			tmpx += x;
		}
	}
}
