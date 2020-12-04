package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SW_EX_D4_방향전환 {
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int targetx = Integer.parseInt(st.nextToken());
            int targety = Integer.parseInt(st.nextToken());
            int result=Integer.MAX_VALUE;
             
            for (int i = 0; i < 2; i++) { // 가로먼저 , 세로먼저
                int dir = i; //현재 방향 저장해줄 dir
                int cnt=0;
                int tmpx=x; int tmpy=y;
                while (true) {
                    if(tmpx==targetx && tmpy==targety) break;
                    cnt++;
                    if (dir == 0) {
                        if (tmpx >= targetx) tmpx += dx[0];
                        else tmpx += dx[1];
                    } 
                    else {
                        if (tmpy >= targety) tmpy += dy[2];
                        else tmpy += dy[3];
                    }
                    dir=(dir+1)%2;
                }
                result=Math.min(result, cnt);
            }
            System.out.println("#"+tc+" "+result);
        }
    }
}