package com.ff.leetcode;

public class WordSearch {
	public static void main(String[] args) {
		char[][] board = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
		String word = "ABC";
		System.out.println(exist(board, word));
	}

	private static int count = 1;

	public static boolean exist(char[][] board, String word) {
		// 对每一个节点进行深搜
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs2(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	// dfs搜索
	public static boolean dfs2(char[][] board, String word, int index, int x, int y) {
		// System.out.println(count++ + "board[" + x + "][" + y + "]:" +
		// board[x][y] + "  word[" + index + "]" + word.charAt(index));

		if (index > word.length()) {
			return false;
		}
		char tmp = board[x][y];

		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		if (index == word.length() - 1 && word.charAt(index) == board[x][y]) {
			// System.out.println("board[" + x + "][" + y + "]:" + board[x][y] +
			// "  word[" + index + "]" + word.charAt(index));
			// for (int i = 0; i < board.length; i++) {
			// for (int j = 0; j < board[0].length; j++) {
			// if (board[i][j] == '.') {
			// System.out.print("[" + i + "][" + j + "]" + " ");
			// }
			// }
			// }

			// System.out.print("[" + x + "][" + y + "]" + " ");
			return true;
		}
		if (word.charAt(index) != board[x][y]) {
			return false;
		}
		board[x][y] = '.';
		if (x - 1 >= 0 && board[x - 1][y] != '.') {
			b1 = dfs2(board, word, index + 1, x - 1, y);
		}
		if (!b1 && y - 1 >= 0 && board[x][y - 1] != '.') {
			b2 = dfs2(board, word, index + 1, x, y - 1);
		}
		if (!b1 && !b2 && x + 1 <= board.length - 1 && board[x + 1][y] != '.') {
			b3 = dfs2(board, word, index + 1, x + 1, y);
		}
		if (!b1 && !b2 && !b3 && y + 1 <= board[0].length - 1 && board[x][y + 1] != '.') {
			b4 = dfs2(board, word, index + 1, x, y + 1);
		}
		board[x][y] = tmp;

		return b1 || b2 || b3 || b4;

	}

	// dfs搜索
	public static boolean dfs(char[][] board, String word, int index, int x, int y) {
		if (index == word.length() - 1 && word.charAt(index) == board[x][y]) {
			return true;
		}
		if (word.charAt(index) != board[x][y]) {
			return false;
		}
		char tmp = board[x][y]; // 保存原始值
		board[x][y] = '.';
		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		if (x - 1 >= 0 && board[x - 1][y] != '.') {
			b1 = dfs(board, word, index + 1, x - 1, y);
		}
		if (!b1 && y - 1 >= 0 && board[x][y - 1] != '.') {
			b2 = dfs(board, word, index + 1, x, y - 1);
		}
		if (!b1 && !b2 && x + 1 < board.length && board[x + 1][y] != '.') {
			b3 = dfs(board, word, index + 1, x + 1, y);
		}
		if (!b1 && !b2 && !b3 && y + 1 < board[0].length && board[x][y + 1] != '.') {
			b4 = dfs(board, word, index + 1, x, y + 1);
		}

		board[x][y] = tmp; // 还原原始值
		return b1 || b2 || b3 || b4;
	}
}
