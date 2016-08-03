package DFS_BFS;

//### + ### = ####; 用1-9 数字填入，输出所有可能结果

public class DFSDigitTest {
	int[] book;
	int[] num;
	int N;

	public DFSDigitTest() {
		book = new int[10];
		num = new int[10];
		N = 9;
		dfs(0);
	}

	public void dfs(int step) {
		if (step == N) {
			if (check())
				printState();

			return;
		}

		for (int i = 0; i < N; i++) {
			if (book[i] == 0) {
				num[step] = i;
				book[i] = 1;
				dfs(step + 1);
				book[i] = 0;
			}
		}
		return;
	}

	public boolean check() {
		return ((-num[6] * 1000 + (num[0] + num[3] - num[7]) * 100 + (num[1] + num[4] - num[8]) * 10 + num[2] + num[5]
				- num[9]) == 0);
	}

	public void printState() {
		System.out.print(num[0]);
		System.out.print(num[1]);
		System.out.print(num[2]);

		System.out.print(" + ");

		System.out.print(num[3]);
		System.out.print(num[4]);
		System.out.print(num[5]);
		System.out.print(" = ");

		System.out.print(num[6]);
		System.out.print(num[7]);
		System.out.print(num[8]);
		System.out.print(num[9]);

		System.out.println();
	}

}
