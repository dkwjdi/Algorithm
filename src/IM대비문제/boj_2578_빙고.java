package IM대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2578_빙고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bingo[][] = new int [5][5];
		boolean check[][] = new boolean [5][5];
		///////빙고판입력
		for(int i=0; i<5; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++) {
				bingo[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		///////빙고판입력
		///////사회자가 불러주는거 입력받기
		int cnt=0;
		for(int i=0; i<5; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++) {
				int number=Integer.parseInt(st.nextToken());
				//////사회자가 부른 숫자 check배열에서 treu로 변경
				 outer :for(int x=0; x<5; x++) {
					for(int y=0; y<5; y++) {
						if(bingo[x][y]==number) {
							check[x][y]=true;
							cnt++;
							break outer;
						}
					}
				}
			    //////사회자가 부른 숫자 check배열에서 true로 변경
				/////////////////빙고체크
				int bingocheck=0;
				int tmp=0;
				//열체크
				for(int y=0; y<5; y++) {
					tmp =0;
					for(int x=0; x<5; x++) {
						if(!check[x][y]) break;
						if(++tmp==5) bingocheck++;
					}
				}
				//행체크
				for(int x=0; x<5; x++) {
					tmp=0;
					for(int y=0; y<5; y++) {
						if(!check[x][y]) break; 
						if(++tmp==5) bingocheck++;
					}
				}
				//오른쪽아래대각선
				tmp =0;
				for(int x=0; x<5; x++) {
					if(!check[x][x]) break;
					if(++tmp==5) bingocheck++;
				}
				//왼쪽아래 대각선
				tmp =0;
				for(int x=0; x<5; x++) {
					if(!check[x][4-x]) break;
					if(++tmp==5) bingocheck++;
				}
				if(bingocheck>=3) {
					System.out.println(cnt);
					return ;
				}
				/////////////////빙고체크
			}
		}
		
	}

}
