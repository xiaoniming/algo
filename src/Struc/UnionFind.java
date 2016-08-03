package Struc;

import Utils.U;

// 动态连通性问题
public class UnionFind {
	int[] id;
	int group;

	public UnionFind(int[] id) {
		this.id = id;
		group = id.length;
	}

	public void connect(int i, int j) {
		int iID, jID;
		iID = findGroup(i);
		jID = findGroup(j);
		if (iID != jID) {
			id[jID] = iID;
			group--;
		}
	}

	public int findGroup(int i) {
		if (id[i] == i)
			return i;
		else {
			id[i] = findGroup(id[i]);
			return id[i];
		}

	}

	public int getTotalGroup() {
		return group;
	}

	{// Test case
		int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		UnionFind uf = new UnionFind(num);
		uf.connect(1, 2);
		uf.connect(3, 4);
		uf.connect(5, 2);
		uf.connect(4, 6);
		uf.connect(2, 6);
		uf.connect(8, 7);
		uf.connect(9, 7);
		uf.connect(1, 6);
		uf.connect(2, 4);
		U.print(num);
	}

}
