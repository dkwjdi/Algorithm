package 프로그래머스;

import java.util.Stack;

public class 크레인인형뽑기 {
	static class Solution {
		public int solution(int[][] board, int[] moves) {

			Stack<Integer> stack = new Stack<>();
			int cnt=0;

			for (int i = 0; i < moves.length; i++) {
				int num = pick(moves[i]-1, stack, board);
				if (num != -1) { // 뽑았다면
					if (stack.isEmpty())
						stack.push(num);
					else {
						int lastNum = stack.pop();
						if (lastNum != num) {
							stack.push(lastNum);
							stack.push(num);
						}
						else cnt++;
					}
				}

			}
			return cnt;
		}

		private int pick(int moves, Stack<Integer> stack, int[][] board) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][moves] != 0) {
					int num = board[i][moves];
					board[i][moves] = 0;
					return num;
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		new Solution().solution(board, moves);
	}

}
