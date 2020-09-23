package IM대비문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2477_참외밭 {
	static class Rec {
		int dir;
		int length;
		Rec(int dir, int length) {
			this.dir = dir;
			this.length = length;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Rec> list = new ArrayList<>();
		int melon = Integer.parseInt(br.readLine());
		
		int maxWidth=0;
		int maxHeight=0;

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int dir=Integer.parseInt(st.nextToken());
			int length=Integer.parseInt(st.nextToken());
			list.add(new Rec(dir,length));
			if (list.get(i).dir == 1 || list.get(i).dir == 2) //넓이 최대값
				maxWidth = Math.max(list.get(i).length, maxWidth);
			if (list.get(i).dir == 3 || list.get(i).dir == 4)
				maxHeight = Math.max(list.get(i).length, maxHeight); //높이 최대값
		}
		int result = maxHeight * maxWidth;
		list.add(list.get(0)); //맨앞에꺼 맨뒤로 하나 넣어줌

		for (int i = 0; i < list.size() - 1; i++) {
			Rec tmp1 = list.get(i); //지금꺼랑
			Rec tmp2 = list.get(i + 1); //그다음까지 
			if ((tmp1.dir == 1 && tmp2.dir == 3) ||  //1번케이스
				(tmp1.dir == 2 && tmp2.dir == 4) ||  //2번케이스
				(tmp1.dir == 3 && tmp2.dir == 2) || 
				(tmp1.dir == 4 && tmp2.dir == 1)) {
				result -= tmp1.length * tmp2.length;
				break;
			}
		}
		System.out.println(result * melon);
	}
}