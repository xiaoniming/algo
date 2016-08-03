package Algo_DFS_BFS;

import java.util.Scanner;
/*
 * 0-1 1-3 0-2 2-4 0-4 linked search all using bfs*/

public class BFStest {
	int head = 0, tail = 0;
	int queue[];
	int book[];
	int N;
	int e[][];

	public static void main(String[] args) {
		new BFStest();
	}

	public BFStest() {
		queue = new int[500];
		readData();
		search(0);
	}

	public void search(int begin) {
		int current;
		queue[tail++] = begin;
		book[begin] = 1;

		while (tail != head) {
			current = queue[head];
			System.out.println(current);

			for (int i = 0; i < N; i++) {
				if (e[current][i] == 1 && book[i] == 0) {
					queue[tail++] = i;
					book[i] = 1;
				}
			}
			head++;
		}
	}

	public void readData() {
		int m = 0;
		int a, b;

		Scanner s = new Scanner(System.in);
		System.out.print("Enter N: ");
		N = s.nextInt();

		book = new int[N];
		e = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					e[i][j] = 0;
				else
					e[i][j] = -1;
			}
		}

		System.out.print("\nEnter linked line nums m: ");
		m = s.nextInt();

		System.out.println("\nEnter linked dot pairs :");
		for (int i = 0; i < m; i++) {
			a = s.nextInt();
			b = s.nextInt();
			e[a][b] = e[b][a] = 1;
		}

	}

}
