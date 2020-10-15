package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class 핀볼게임 {
    static class warmhole{
        int number;
        int x,y;
        public warmhole(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
         
    }
    static int map[][],N,result, hole[][], size;
    static List<warmhole> list;
    // 좌 우 상 하
    static int []dx= {0,0,-1,1};
    static int []dy= {-1,1,0,0};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
         
         
        for(int tc=1; tc<=T; tc++) {
            list=new ArrayList<>();
             N=Integer.parseInt(br.readLine());
             map = new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<N; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                    if(map[i][j]>=6 && map[i][j]<=10) { //웜홀이면 
                        list.add(new warmhole(map[i][j],i,j));
                    }
                     
                }
            }
            size=list.size();
            solve();
            System.out.println("#"+tc+" "+result);
            result=0;
             
        }
    }
    private static void solve() {
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(map[i][j]==0) {
                    cnt=start(i,j);
                    if(cnt>result) result=cnt;
                }
            }
        }
         
    }
    private static int start(int x, int y) {
        int cnt=0;
        int maxcnt=0;
        // 좌 우 상 하
        for(int i=0; i<4; i++) {
            int tmpi=i;
            int nx=x;
            int ny=y;
            cnt=0;
             
            while(true) {
                 
                nx+=dx[tmpi];
                ny+=dy[tmpi];
                 
                 
                if(nx==x && ny==y) break;
                if(nx<0 || ny<0 || nx>=N || ny>=N) { //벽에 부딪치면
                    if(tmpi==0) tmpi=1;
                    else if(tmpi==1) tmpi=0;
                    else if(tmpi==2) tmpi=3;
                    else tmpi=2;
                    cnt++;
                    continue;
                }
                // 0 좌 
                // 1 우
                // 2 상
                // 3 하
                if(map[nx][ny]==-1) break;  //블랙홀 만나면 끝
                if(map[nx][ny]>=6&& map[nx][ny]<=10) { //웜홀을 만낫다면
                    int number=map[nx][ny];
                     
                    for(int k=0; k<size; k++) {
                        warmhole tmp=list.get(k);
                        int holenumber=tmp.number;
                        int tmpx=tmp.x;
                        int tmpy=tmp.y;
                         
                        if(holenumber==number) { //번호가 같고
                            if(tmpx==nx && tmpy==ny) continue;
                            else {
                                nx=tmpx;
                                ny=tmpy;
                                break;
                            }
                             
                        }
                    }
                }
                 
                if(tmpi==0) { //좌
                    if(map[nx][ny]==1) {
                        tmpi=2;
                        cnt++;
                    }
                    else if(map[nx][ny]==2) {
                        tmpi=3;
                        cnt++;
                         
                    }
                    else if(map[nx][ny]==3) {
                        tmpi=1;
                        cnt++;
                    }
                    else if(map[nx][ny]==4) {
                        tmpi=1;
                        cnt++;
                    }
                    else if(map[nx][ny]==5) {
                        tmpi=1;
                        cnt++;
                    }
                     
                     
                }
                // 0 좌 
                // 1 우
                // 2 상
                // 3 하
                else if(tmpi==1) { //우
                    if(map[nx][ny]==1) {
                        tmpi=0;
                        cnt++;
                    }
                    else if(map[nx][ny]==2) {
                        tmpi=0;
                        cnt++;
                         
                    }
                    else if(map[nx][ny]==3) {
                        tmpi=3;
                        cnt++;
                    }
                    else if(map[nx][ny]==4) {
                        tmpi=2;
                        cnt++;
                    }
                    else if(map[nx][ny]==5) {
                        tmpi=0;
                        cnt++;
                    }
                     
                }
                // 0 좌 
                // 1 우
                // 2 상
                // 3 하
                else if(tmpi==2) { //상
                    if(map[nx][ny]==1) {
                        tmpi=3;
                        cnt++;
                    }
                    else if(map[nx][ny]==2) {
                        tmpi=1;
                        cnt++;
                         
                    }
                    else if(map[nx][ny]==3) {
                        tmpi=0;
                        cnt++;
                    }
                    else if(map[nx][ny]==4) {
                        tmpi=3;
                        cnt++;
                    }
                    else if(map[nx][ny]==5) {
                        tmpi=3;
                        cnt++;
                    }
                }
                // 0 좌 
                // 1 우
                // 2 상
                // 3 하
                else { //하
                    if(map[nx][ny]==1) {
                        tmpi=1;
                        cnt++;
                    }
                    else if(map[nx][ny]==2) {
                        tmpi=2;
                        cnt++;
                         
                    }
                    else if(map[nx][ny]==3) {
                        tmpi=2;
                        cnt++;
                    }
                    else if(map[nx][ny]==4) {
                        tmpi=0;
                        cnt++;
                    }
                    else if(map[nx][ny]==5) {
                        tmpi=2;
                        cnt++;
                    }
                }
                 
                 
            }
            if(cnt>maxcnt) maxcnt=cnt;
        }
        return maxcnt;
    }
     
     
 
}