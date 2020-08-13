package Greed;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj_1931_200806 {

	static class sf {
		int start, end;

		sf(int start, int end) {
			this.start = start;
			this.end = end;
		}
		sf() {
		}
		@Override
		public String toString() {
			return "sf [start=" + start + ", end=" + end + "]";
		};
	}

	static class sfComparator implements Comparator<sf> {

		@Override
		public int compare(sf o1, sf o2) {
			if(o1.end==o2.end) return o1.start-o2.start;
			return o1.end - o2.end;
		}

	}

	static sf meeting[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		meeting = new sf[N];
		int start, end;

		for (int i = 0; i < N; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			meeting[i] = new sf(start, end);
		}
		Arrays.sort(meeting, new sfComparator());

		int cnt = 1;
		end = meeting[0].end;
		for (int i = 1; i < N; i++) {
			
			if(meeting[i].start>=end) {
				cnt++;
				end=meeting[i].end;
			}

		}
		System.out.println(cnt);

	}

}
