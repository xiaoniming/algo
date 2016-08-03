package Algo_DFS_BFS;

import java.util.Scanner;

import Utils.U;

//maze
//0 Blocked; 1 path; start form dx,dy ,check longest available path in maze
public class NetEase_maze {

	private static int n, m, dx, dy, k;
	private static int[][] maze;
	private static int[][] step;
	private static int max = 0;
	static int[][] book_dfs;

	public static void main(String[] args) {
		getInput();
		isPathDFS(dx, dy, 1);
		U.print(max);
	}

	public static void isPathDFS(int i, int j, int curMax) {

		// Boundary or have been or blocked
		if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || book_dfs[i][j] == 1 || maze[i][j] == 0) {
			if (max < curMax - 1) {
				max = curMax - 1;
			}
			return;
		}
		book_dfs[i][j] = 1;
		// U.print("dfs in " + i + " , " + j + " curMax: " + curMax);
		for (int t = 0; t < k; t++) {
			isPathDFS(i + step[t][0], j + step[t][1], curMax + 1);
		}
		book_dfs[i][j] = 0;

	}

	public static void getInput() {
		Scanner scanner = new Scanner(System.in);
		m = 0;
		n = 0;
		if (scanner.hasNextInt())
			m = scanner.nextInt();

		if (scanner.hasNextInt())
			n = scanner.nextInt();

		maze = new int[m][n];
		book_dfs = new int[m][n];

		scanner.nextLine(); // 去掉回车符
		for (int i = 0; i < m; i++) {
			if (scanner.hasNext()) {
				String string2 = scanner.nextLine();
				maze[i] = new int[n];
				for (int j = 0; j < n; j++) {
					char a = string2.charAt(j);
					char dian = '.';
					if (a == dian) {
						maze[i][j] = 1; // path
					} else {
						maze[i][j] = 0; // block
					}
				}
			}
		}
		if (scanner.hasNext()) {
			dx = scanner.nextInt();
			dy = scanner.nextInt();
			k = scanner.nextInt();
		}
		step = new int[k][2];

		scanner.nextLine();
		for (int i = 0; i < k; i++) {
			step[i] = new int[2];
			step[i][0] = scanner.nextInt();
			step[i][1] = scanner.nextInt();
		}
		scanner.close();
		return;
	}

}
