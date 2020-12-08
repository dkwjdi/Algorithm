package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14891_톱니바퀴 {
	static class Info{
		int no, dir;
		public Info(int no, int dir) {
			this.no = no-1;
			this.dir = dir;
		}
	}
	static List<Integer> list[];
	static List<Info> infoList=new ArrayList<>();
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list=new List[4];
		for(int i=0; i<4; i++) list[i]=new ArrayList<>();
		
		for(int i=0; i<4; i++) {
			String input=br.readLine();
			for(int j=0; j<8; j++) {
				list[i].add(input.charAt(j)-'0');
			}
		}
		
		K=Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			infoList.add(new Info( Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		solve();
		System.out.println(result());
		
	}
	private static int result() {
		int sum=0;
		for(int i=0; i<4; i++) {
			if(list[i].get(0)==1) sum+=Math.pow(2, i);
		}
		return sum;
	}
	private static void solve() {
		for(int i=0; i<K; i++) {
			Info info = infoList.get(i);
			left(info.no-1,-info.dir);
			right(info.no+1,-info.dir);
			rotate(info.no,info.dir); //자기 번호 회전
		}
		
	}
	private static void right(int no, int dir) {
		if(no==4) return;
		
		if(list[no].get(6)!=list[no-1].get(2)) {
			right(no+1,-dir);
			rotate(no, dir);
		}
	}
	
	private static void left(int no, int dir) {
		if(no==-1) return ;
		
		if(list[no].get(2)!=list[no+1].get(6)) {
			left(no-1,-dir);
			rotate(no, dir);
		}
	}
	private static void rotate(int no, int dir) {
		if(dir==1) { //시계
			int ns=list[no].remove(7);
			list[no].add(0,ns);
		}
		else { //반시계
			int ns=list[no].remove(0);
			list[no].add(ns);
		}
		
	}

}
