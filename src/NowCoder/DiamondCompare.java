package NowCoder;

import java.util.ArrayList;

//一堆钻石已编号，小明随机挑取两个比较，比较完成后记录 在class Cmp {int heavy; int light;}，然后放回堆中。现随机在其中取出两个编号为：g1 g2，能否通过已知记录判断轻重？
//g1 重 返回1， g2 重返回-1， 无法比较 返回0；
public class DiamondCompare {
	ArrayList<Cmp> list;
	int g1;
	int g2;
	boolean FLAG = false;

	public DiamondCompare() {
		// 记录 list 的初始化
		list = new ArrayList<>();
		list.add(new Cmp(10, 3));
		list.add(new Cmp(10, 9));
		list.add(new Cmp(9, 8));
		list.add(new Cmp(9, 2));
		list.add(new Cmp(2, 1));
		list.add(new Cmp(2, 0));
		list.add(new Cmp(8, 5));
		list.add(new Cmp(7, 6));
		list.add(new Cmp(8, 4));
		list.add(new Cmp(4, 5));
		list.add(new Cmp(5, 11));

		g1 = 10;
		g2 = 5;

		// Main function
		if (dfs(g1, g2)) {
			System.out.println(1);
			FLAG = false;
		} else if (dfs(g2, g1)) {
			System.out.println(-1);
			FLAG = false;
		} else
			System.out.println(0);
	}

	// 此处采用DFS搜索，搜索完成后 置FLAG 为true
	public boolean dfs(int step, int target) {
		if (!FLAG) {
			for (Cmp each : list) {
				if (each.h == step && each.l == target)
					FLAG = true;
			}
			for (Cmp each : list) {
				if (step == each.h) {
					dfs(each.l, target);
				}

			}

		}
		return FLAG;
	}

}

class Cmp {
	int h;
	int l;

	public Cmp(int hh, int ll) {
		h = hh;
		l = ll;
	}
}
