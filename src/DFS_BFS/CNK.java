package DFS_BFS;

import java.util.ArrayList;

import Utils.U;

//print all combinations of choosing k elements from N in total;
//eg. N = 3; K = 2;
//print:{[1,2],[1,3],[2,3]}
public class CNK {
	int N, K;
	int[] tmp;

	public static void main(String[] args) {
		CNK cnk = new CNK(4, 3);
		// Method 1
		cnk.dfs(1, 1);

		// Method 2
		for (ArrayList<Integer> t : cnk.rec(4, 3)) {
			System.out.print(t);
		}
	}

	public CNK(int N, int K) {
		this.N = N;
		this.K = K;
		tmp = new int[K];
	}

	/**
	 * DFS solve this�� for not repeat, define a begin num. Step is the box No.
	 * to put the num, when step > K then over and print. Try every possible num
	 * and then go to next box
	 **/

	public void dfs(int step, int begin) {
		if (step > K) {
			U.print(tmp);
			return;
		}
		for (int i = begin; i <= N; i++) {
			tmp[step - 1] = i;
			begin = i + 1; // for next box do not use nums used before
			dfs(step + 1, begin);
		}
		return;
	}

	/**
	 * This recursive(递归) Method use the formula C(N,K)= N*C(N-1,K-1)+""C(N-1,K)
	 * use ArrayList<ArrayList<Integer>> to store the final results
	 * eg.{[1,2],[1,3],[2,3]}
	 **/

	public ArrayList<ArrayList<Integer>> rec(int n, int k) {
		if (k <= 0) { // when k==0, means reach the recursive bottom
						// we create an ArrayList<ArrayList<Integer>> to store
			ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
			tmp.add(new ArrayList<Integer>());
			return tmp;
		}
		if (k > n) // reach end; no further possibilities
			return null;
		ArrayList<ArrayList<Integer>> c1 = rec(n - 1, k - 1);
		ArrayList<ArrayList<Integer>> c2 = rec(n - 1, k);
		if (c1 != null) {
			for (ArrayList<Integer> t : c1) {
				t.add(n); // add n to every list in our final list
			}
		}
		if (c2 != null) {
			c1.addAll(c2); // combine two lists
		}
		return c1;
	}

}
