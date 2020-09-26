package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 원자소멸시뮬레이션 {
	static class Atom {
		int x, y, dir, power;

		public Atom(int x, int y, int dir, int power) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.power = power;
		}
	}
	static int map[][] = new int[4001][4001];
	static int N, result;
	static int dx[] = { 0, 0, -1, 1 }; // 상 하 좌 우
	static int dy[] = { 1, -1, 0, 0 };
	static List<Atom> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			list = new ArrayList<>();
			N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) { // 입력
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int dir = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				list.add(new Atom(x, y, dir, power));
			}
			solve();
			sb.append("#"+tc+" "+result+"\n");
			result = 0;
		}
		System.out.println(sb);
	}

	private static void solve() {

		while (!list.isEmpty()) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Atom atom = list.get(i);
				map[atom.x][atom.y] = 0; // 원래 잇던자리 초기화해주고

				int nx = atom.x + dx[atom.dir];
				int ny = atom.y + dy[atom.dir];

				if (nx < 0 || ny < 0 || nx > 4000 || ny > 4000) {
					atom.power = 0;
				} else {
					map[nx][ny] += atom.power;
					atom.x = nx;
					atom.y = ny;
				}
			} // size

			// 소멸한거확인

			for (int i = 0; i < size; i++) {
				Atom atom = list.get(i);

				if (atom.power == 0)
					continue;

				if (map[atom.x][atom.y] != atom.power) { // 충돌햇네 ?
					result += map[atom.x][atom.y];
					atom.power = map[atom.x][atom.y] = 0; // 맵이랑 원자power 0 으로 바꿔줌
				}
			}
			
			int index=0;
			while(true) { // power가 0인 원자 다 삭제
				if(index==list.size()) break;
				Atom atom= list.get(index);
				if(atom.power==0) {
					list.remove(index);
					continue;
				}
				index++;
			}
		} //while 끝
	} //solve 끝
}
