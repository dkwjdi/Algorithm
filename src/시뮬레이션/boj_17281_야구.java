package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17281_야구 {
	static int N, info[][] ,players[], result;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

		N = Integer.parseInt(br.readLine());
		info = new int[N+1][10];
		players = new int[10];
		visited = new boolean[10];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				info[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		permutation(1);
		System.out.println(result);
		
	}
	private static void permutation(int cnt) {
		if(cnt==4) {
			players[cnt]=1;
			permutation(cnt+1);
		}
		if(cnt==10) {
			//System.out.println(Arrays.toString(players));
			result=Math.max(result, play());
			return;
		}
		for(int i=2; i<=9; i++) {
			if(visited[i]) continue;
			players[cnt]=i;
			visited[i]=true;
			permutation(cnt+1);
			visited[i]=false;
		}
	}
	private static int play() {
		int score=0;
		int playesIdx=1;
		for(int inning=1; inning<=N; inning++) {
			int out=0;
			boolean base[] = new boolean [5];
			while(out<3) {
				if(info[inning][players[playesIdx]]==0) out++;
				else if(info[inning][players[playesIdx]]==1) score+=calScore(1, base);
				else if(info[inning][players[playesIdx]]==2) score+=calScore(2, base);
				else if(info[inning][players[playesIdx]]==3) score+=calScore(3, base);
				else if(info[inning][players[playesIdx]]==4) score+=calScore(4, base);
				
				if(++playesIdx==10) playesIdx=1; //다음선수로 
				
			}
		}
		return score;
	}
	private static int calScore(int roota, boolean[] base) {
		int score=0;
		if(roota>=3) {
			for(int i=1; i<=3; i++) {
				if(base[i]) {
					score++;
					base[i]=false;
				}
			}
			if(roota==3) {
				base[3]=true;
				return score;
			}
			else return ++score;
		}
		
		else { //1 , 2 루타
			for(int i=3; i>0; i--) {
				if(base[i]) { //현재 값이 true 이면 
					base[i]=false;
					if(i+roota > 3) score++;  //홈으로 들어올 상황
					else  base[i+roota]=true; // 홈으로 들어올 상황 x 
				}
			}
			base[roota]=true;
			return score;
		}
	}
}
