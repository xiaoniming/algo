package Algo_DFS_BFS;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Utils.U;

// 0 Blocked; 1 path; start form 0,0 ,check whether can fetch 9 in maze
public class BFS_DFS_Maze_Search {

	final private static int BLOCKED = 0;
	final private static int PATH = 1;
	final private static int NOT_AVAILABLE = 1;
	final private static int AVAILABLE = 0;

	static boolean FLAG_FOUND = false;
	static int[][] book_dfs;
	static int[][] book_bfs;
	static Stack<Point> curPath = new Stack<>();

	static int maze[][] = { { 1, 1, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0 },
			{ 1, 0, 1, 0, 9, 0, 1, 1 }, { 1, 1, 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static void main(String[] args) {
		for (int i = 0; i < maze.length; i++) {
			U.print(maze[i]);
		}

		book_dfs = new int[8][];
		book_bfs = new int[8][];
		for (int i = 0; i < book_dfs.length; i++) {
			book_dfs[i] = new int[8];
			book_bfs[i] = new int[8];
		}
		isPathDFS(0, 0);
		U.print(isPathBFS());
	}

	/** DFS: find all path **/
	public static void isPathDFS(int i, int j) {

		// Boundary or have been or blocked
		if (i < 0 || i > 7 || j < 0 || j > 7 || book_dfs[i][j] == NOT_AVAILABLE || maze[i][j] == BLOCKED)
			return;

		// find
		if (maze[i][j] == 9) {
			// print curPath
			FLAG_FOUND = true;
			curPath.add(new Point(i, j));
			for (Point p : curPath) {
				System.out.print("(" + (int) p.getX() + "," + (int) p.getY() + ")");
			}
			System.out.println();
			curPath.pop();
			return;
		}
		// next step
		else {
			book_dfs[i][j] = NOT_AVAILABLE;
			curPath.push(new Point(i, j));
			isPathDFS(i, j - 1);
			isPathDFS(i - 1, j);
			isPathDFS(i + 1, j);
			isPathDFS(i, j + 1);
			book_dfs[i][j] = AVAILABLE;
			curPath.pop();
		}

	}

	/** BFS : only find the nearest path **/
	public static boolean isPathBFS() {
		int i, j;
		Queue<XY> queue = new LinkedList<>();
		queue.add(new XY(0, 0, null));

		while (!queue.isEmpty()) {
			// remove the queue head
			XY cur = queue.poll();
			i = cur.i;
			j = cur.j;

			// out of boundary or blocked or been there
			if (i < 0 || i > 7 || j < 0 || j > 7 || maze[i][j] == BLOCKED || book_bfs[i][j] == NOT_AVAILABLE)
				continue;

			// find
			if (maze[i][j] == 9) {
				// Print path, note that path is reversed
				while (cur.pre != null) {
					System.out.print(cur);
					cur = cur.pre;
				}
				System.out.println(cur);// begin node
				book_bfs[i][j] = NOT_AVAILABLE;
				return true;
			}

			// next 4 steps added to queue
			else {
				book_bfs[i][j] = NOT_AVAILABLE;
				queue.add(new XY(i, j - 1, cur));
				queue.add(new XY(i, j + 1, cur));
				queue.add(new XY(i - 1, j, cur));
				queue.add(new XY(i + 1, j, cur));
			}
		}
		return false;
	}

}

class XY {
	public int i, j;
	public XY pre;

	public XY(int i, int j, XY pre) {
		this.i = i;
		this.j = j;
		this.pre = pre;
	}

	@Override
	public String toString() {
		return "(" + i + "," + j + ")";
	}
}