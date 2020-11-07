package 모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class 점심식사시간 {
    static class Person implements Comparable<Person>{
        int x,y,time;
 
        public Person(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
 
        @Override
        public int compareTo(Person o) {
            return this.time-o.time;
        }
         
         
    }
    static List <int[]> personlist;
    static PriorityQueue <Person> stair1;
    static PriorityQueue <Person> stair2;
    static int map[][], N, result;
    static boolean check[];
    static int stair[][] = new int[2][3];
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st=null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            result=Integer.MAX_VALUE;
            personlist = new ArrayList<>();
            int index=0;
            int personcnt=0;
            N =  Integer.parseInt(br.readLine());
 
            map = new int[N][N];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < N; j++) {
                    int tmp= Integer.parseInt(st.nextToken());
                    map[i][j] = tmp;
                    if(map[i][j]==1) {
                        personlist.add(new int[] {i,j});
                        personcnt++;
                    }
                    else if(tmp>1) {
                        stair[index][0]=tmp;
                        stair[index][1]=i;
                        stair[index++][2]=j;
                    }
                }
            }
            solve();
            System.out.println("#"+tc+" "+(result+1));
        }
    }
    private static void solve() {
        int size=personlist.size();
        check = new boolean[size+1];
        powerset(0,size);
         
    }
    private static void powerset(int cnt,int size) {
         
        if(cnt==size) { //다 뽑았으면 
            //1 2 스테어에 각각 사람 넣어준다.
            stair1=new PriorityQueue<>();
            stair2=new PriorityQueue<>();
             
            for(int i=0; i<size; i++) {
                int tmp[]=personlist.get(i);
                int x=tmp[0];
                int y=tmp[1];
                if(check[i]) { // 1번 계단
                    int dir=dir1(x,y);
                    stair1.add(new Person(x,y,dir));
                }
                else { //2번계단
                    int dir=dir2(x,y);
                    stair2.add(new Person(x,y,dir));
                }
            }
             
            result=Math.min(result, timestart());
             
            return ;
        }
         
        check[cnt]=true;
        powerset(cnt+1,size);
         
         
        check[cnt]=false;
        powerset(cnt+1,size);
         
         
    }
    private static int timestart() {
        int time=0;
        int firsts[][]=new int[3][2];
        int seconds[][]=new int[3][2];
        while(true) {
            time++;
             
            //계단 다 내려간사람 배열에서 빼주기
            for(int i=0; i<3; i++){
                if(firsts[i][0]!=0) { //계단에 사람이 있으면! 시간 --해줘야됨 
                    firsts[i][1]=firsts[i][1]-1;
                    if(firsts[i][1]==0) firsts[i][0]=0;
                }
                 
                if(seconds[i][0]!=0) { //계단에 사람이 있으면! 시간 --해줘야됨 
                    seconds[i][1]=seconds[i][1]-1;
                    if(seconds[i][1]==0) seconds[i][0]=0;
                }
            }
             
             
             
            int size1=stair1.size();
            for(int i=0;i<size1;i++) {
                if(stair1.peek().time>time) break; //아직 도착한 사람 없음
                Person p =stair1.poll(); //도착 했다면 꺼낸다.
                if(stairStatus(firsts)) {// 배열이 비어있따면
                    insert(firsts,p,0);
                }
                else { //계단 꽉차서 못들어감 다시 넣어줌
                    stair1.add(p);
                    break;
                }
            }
             
            int size2=stair2.size();
            for(int i=0;i<size2;i++) {
                if(stair2.peek().time>time) break; //아직 도착한 사람 없음
                Person p =stair2.poll(); //도착 했다면 꺼낸다.
                if(stairStatus(seconds)) {// 배열이 비어있따면
                    insert(seconds,p,1);
                }
                else { //계단 꽉차서 못들어감 다시 넣어줌
                    stair2.add(p);
                    break;
                }
            }
             
            size1=stair1.size();
            size2=stair2.size();
            if(size1==0 && size2==0 && outstair(firsts) && outstair(seconds)) 
                break;
             
             
             
             
             
             
             
        }
        return time;
    }
    private static boolean outstair(int[][] stair) {
        for(int i=0; i<3; i++) {
            if(stair[i][0]!=0) return false;
        }
        return true;
    }
    private static void insert(int[][] firsts,Person p,int s) {
        for(int i=0; i<3; i++) {
                if(firsts[i][0]==0) {
                    firsts[i][0]=1;
                    firsts[i][1]=stair[s][0];
                    return ;
                }
             
        }
    }
    private static boolean stairStatus(int [][]s) {
        int check=0;
        for(int i=0; i<3; i++) {
                if(s[i][0]!=0) check++;
        }
        if(check==3) return false;
        else return true;
    }
    private static int dir1(int x, int y) {
        return Math.abs(x-stair[0][1])+Math.abs(y-stair[0][2]);
    }
     
    private static int dir2(int x, int y) {
        return Math.abs(x-stair[1][1])+Math.abs(y-stair[1][2]);
    }
 
}